package ems.DaoServices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonObject;

import ems.logger.Emslogger;
import ems.model.Employee;
import ems.model.Salary;
import ems.services.EmployeeServices;

public class EmployeeDao implements EmployeeServices {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("HibernateTemplate.xml");
	HibernateTemplate template=(HibernateTemplate)ctx.getBean("template");
	Transaction tx;
	Session s=null;
	ArrayList<Employee> i;
	@Transactional(rollbackFor = Exception.class)
	public int addEmployee(Employee emp) {
		try {
			s=template.getSessionFactory().openSession();
			tx=s.beginTransaction();
			int empid=(Integer)s.save(emp);
			s.save(emp.getSal());
			tx.commit();
			Emslogger.info("employee added");
			s=null;
			tx=null;
			return empid;
			}catch(Exception e) {
				tx.rollback();
				e.printStackTrace();
				Emslogger.error(e.getMessage());
				return 0;
			}
	
	}
	@Transactional(rollbackFor = Exception.class)
	public int updateEmployeeDet(Employee emp) {
		try {
			s=template.getSessionFactory().openSession();
			tx=s.beginTransaction();
			s.update(emp);
			tx.commit();
			Emslogger.info("employee updated:"+emp.getEmpid());
			s=null;
			tx=null;
			return 1;
			}catch(Exception e) {
				tx.rollback();
				e.printStackTrace();
				Emslogger.error(e.getMessage());
				return 0;
			}}
	@Transactional(rollbackFor = Exception.class)
	public boolean updateEmployee(Employee emp) {

		try {
			s=template.getSessionFactory().openSession();
			tx=s.beginTransaction();
			Employee emp2=s.get(Employee.class,emp.getEmpid());
			emp.setImage(emp2.getImage());
			emp.setAdhar(emp2.getAdhar());
			emp.setPanimage(emp2.getPanimage());
			s.update(emp);
			s.update(emp.getSal());
			tx.commit();
			Emslogger.info("employee updated"+emp.getEmpid());
			s=null;
			tx=null;
			return true;
			}catch(Exception e) {
				e.printStackTrace();
				Emslogger.error(e.getMessage());
				return false;
				}
	}
	@Transactional(rollbackFor = Exception.class)
	public boolean removeEmployee(Employee employee) {
		try {
			s=template.getSessionFactory().openSession();
			tx=s.beginTransaction();
			Employee emp=(Employee)s.get(Employee.class,employee.getEmpid());
			Salary sal=(Salary)s.get(Salary.class,emp.getSal().getSalid());
			System.out.println(sal);
			String q1="delete from EmployeeMembers where emp_empid="+emp.getEmpid();
			String q2="delete from EmsUsers where emp_empid="+emp.getEmpid();
			@SuppressWarnings("unchecked")
			NativeQuery<Employee> query1=s.createNativeQuery(q1);
			@SuppressWarnings("unchecked")
			NativeQuery<Employee> query2=s.createNativeQuery(q2);
			query1.executeUpdate();
			query2.executeUpdate();
			s.delete(sal);
			s.delete(emp);
			tx.commit();
			Emslogger.info("employee deleted:"+employee.getEmpid()+":"+employee.getName());
			s=null;
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			Emslogger.error(e.getMessage());
			tx.rollback();
			return false;
			}
		
	}
	@Transactional
	public Employee fetchEmployee(int empid) {
		try {
		s=template.getSessionFactory().openSession();
		tx=s.beginTransaction();
		Employee emp=(Employee)s.get(Employee.class,empid);
		tx.commit();
		return emp;
		}catch(Exception e) {
			e.printStackTrace();
			Emslogger.error("error fetching employee:"+e.getMessage());
			return null;
		}
	}
@SuppressWarnings("rawtypes")
public JsonObject getNoOfEmployee() {
	try {
	s=template.getSessionFactory().openSession();
	@SuppressWarnings("unchecked")
	NativeQuery<Employee> query=s.createNativeQuery("select count(*) from Employee");
	List l=query.list();
	@SuppressWarnings("unchecked")
	Iterator<Integer> ite=l.iterator();
	JsonObject jobj=new JsonObject();
	jobj.addProperty("no",ite.next());
	return jobj;
	}catch(Exception e) {
		e.printStackTrace();
		Emslogger.error("error in getting no of employee:"+e.getMessage());
		return null;
	}
}
}
