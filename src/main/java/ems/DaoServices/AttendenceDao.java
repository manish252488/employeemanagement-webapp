package ems.DaoServices;

import java.sql.Date;
import java.sql.Time;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import ems.functions.DateTime;
import ems.model.Attendence;
import ems.services.AttendenceServices;

public class AttendenceDao implements AttendenceServices{
ApplicationContext ctx=new ClassPathXmlApplicationContext("HibernateTemplate.xml");
HibernateTemplate template=(HibernateTemplate)ctx.getBean("template");
Session session;
Transaction tx;
@Transactional
	public String addAttendence(Attendence att) {
		att.setDay(Date.valueOf(DateTime.getCurrentDate()));
		att.setIntime(Time.valueOf(DateTime.getCurrentTime()));
		template.save(att);
		return "attendence";
		
	}
@Transactional
	public String leaveTime(Attendence att) {
		
		return null;
	}

@Transactional(rollbackOn = Exception.class)
public String completeShift(int empid) {
	session=template.getSessionFactory().openSession();
	tx=session.beginTransaction();
	String q="update attendence_log set outtime=:out,hoursWorked=:hw where empid=:empid AND day=:today";
	@SuppressWarnings("unchecked")
	NativeQuery<Attendence> query=session.createNativeQuery(q);
	query.setParameter("out",Time.valueOf(DateTime.getCurrentTime()));
	query.setParameter("hw", 20);
	query.setParameter("empid", empid);
	query.setParameter("today",Date.valueOf(DateTime.getCurrentDate()));
	query.executeUpdate();
	tx.commit();
	return "attendence";
}
}
