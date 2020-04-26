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
			s=null;
			tx=null;
			return empid;
			}catch(Exception e) {
				tx.rollback();
				e.printStackTrace();
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
			s=null;
			tx=null;
			return 1;
			}catch(Exception e) {
				tx.rollback();
				e.printStackTrace();
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
			s=null;
			tx=null;
			return true;
			}catch(Exception e) {e.printStackTrace();return false;}
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
			s=null;
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
			}
		
	}
	@Transactional
	public Employee fetchEmployee(int empid) {
		s=template.getSessionFactory().openSession();
		tx=s.beginTransaction();
		Employee emp=(Employee)s.get(Employee.class,empid);
		tx.commit();
		return emp;
	}
@SuppressWarnings("rawtypes")
public JsonObject getNoOfEmployee() {
	s=template.getSessionFactory().openSession();
	@SuppressWarnings("unchecked")
	NativeQuery<Employee> query=s.createNativeQuery("select count(*) from Employee");
	List l=query.list();
	@SuppressWarnings("unchecked")
	Iterator<Integer> ite=l.iterator();
	JsonObject jobj=new JsonObject();
	jobj.addProperty("no",ite.next());
	return jobj;
}
//public static void main(String args[]) {
//	EmployeeDao d=new EmployeeDao();
//	JsonObject o=d.getNoOfEmployee();
//	System.out.println(o.get("no"));
//}
}
