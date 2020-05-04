package ems.DaoServices;

import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.google.gson.JsonObject;

import ems.functions.DateTime;
import ems.logger.Emslogger;
import ems.model.Attendence;
import ems.services.AttendenceServices;

public class AttendenceDao implements AttendenceServices{
ApplicationContext ctx=new ClassPathXmlApplicationContext("HibernateTemplate.xml");
HibernateTemplate template=(HibernateTemplate)ctx.getBean("template");
Session s;
Transaction tx;
@Transactional
	public String addAttendence(Attendence att) {
	try {
		att.setDay(Date.valueOf(DateTime.getCurrentDate()));
		att.setIntime(Time.valueOf(DateTime.getCurrentTime()));
		template.save(att);
		return "attendence";
	}catch(Exception e) {
		e.printStackTrace();
		Emslogger.error(e.getMessage());
		return "index";
	}
		
	}
@Transactional
	public String leaveTime(Attendence att) {
		
		return null;
	}

@Transactional(rollbackOn = Exception.class)
public String completeShift(int empid) {
	try {
	s=template.getSessionFactory().openSession();
	tx=s.beginTransaction();
	String q="update attendence_log set outtime=:out,hoursWorked=:hw where empid=:empid AND day=:today";
	@SuppressWarnings("unchecked")
	NativeQuery<Attendence> query=s.createNativeQuery(q);
	query.setParameter("out",Time.valueOf(DateTime.getCurrentTime()));
	query.setParameter("hw", 20);
	query.setParameter("empid", empid);
	query.setParameter("today",Date.valueOf(DateTime.getCurrentDate()));
	query.executeUpdate();
	tx.commit();
	return "attendence";
	}catch(Exception e) {
		e.printStackTrace();
		Emslogger.error(e.getMessage());
		return "index";
	}
}
@SuppressWarnings("rawtypes")
public JsonObject getEmpPresent()  {
	try {
	s=template.getSessionFactory().openSession();
	@SuppressWarnings("unchecked")
	NativeQuery<Attendence> query=s.createNativeQuery("select count(*) from attendence_log where day=:today AND intime!='null'");
	query.setParameter("today",Date.valueOf(DateTime.getCurrentDate()));
	List l=query.list();
	@SuppressWarnings("unchecked")
	Iterator<Integer> ite=l.iterator();
	JsonObject jobj=new JsonObject();
	jobj.addProperty("no",ite.next());
	return jobj;
	}catch(Exception e) {
		e.printStackTrace();
		Emslogger.error(e.getMessage());
		return null;
	}
}

}
