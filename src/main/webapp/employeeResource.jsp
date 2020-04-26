<%@page import="ems.model.Employee"%>
<%@page import="org.springframework.orm.hibernate5.HibernateTemplate"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.service.ServiceRegistry"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%! ApplicationContext ctx=null; %>
<%
int id=Integer.parseInt(request.getParameter("id"));

try{
ctx=new ClassPathXmlApplicationContext("HibernateTemplate.xml");
HibernateTemplate template=(HibernateTemplate)ctx.getBean("template");
Session sess=template.getSessionFactory().openSession();
Transaction tx=sess.beginTransaction();
Employee emp=(Employee)sess.get(Employee.class, id);
tx.commit();
JsonObject employee=new JsonObject();
employee.addProperty("deptname",emp.getDept().getDeptname());
employee.addProperty("deptcode",emp.getDept().getCode());
employee.addProperty("deptid",emp.getDept().getDeptid());
employee.addProperty("fname",emp.getName().getFname());
employee.addProperty("mname",emp.getName().getMname());
employee.addProperty("lname",emp.getName().getLname());
employee.addProperty("bdate",emp.getBirthdate().toString());
employee.addProperty("sex",emp.getSex());
employee.addProperty("phno1",emp.getPhoneno1());
employee.addProperty("phno2",emp.getPhoneno2());
employee.addProperty("email",emp.getEmail());
employee.addProperty("sal",emp.getSal().getSalary());
employee.addProperty("bonus",emp.getSal().getBonus());
employee.addProperty("job",emp.getJob());
employee.addProperty("salid",emp.getSal().getSalid());
employee.addProperty("add1",emp.getAdd().getAddress1());
employee.addProperty("add2",emp.getAdd().getAddress2());
employee.addProperty("state",emp.getAdd().getState());
employee.addProperty("city",emp.getAdd().getCity());
employee.addProperty("pin",emp.getAdd().getPincode());
employee.addProperty("acc",emp.getSal().getAccno());
employee.addProperty("ifsc",emp.getSal().getIfsccode());
employee.addProperty("bankname",emp.getSal().getBank_name());
employee.addProperty("adharno", emp.getAdhar());
employee.addProperty("panno", emp.getPanno());
out.print(employee.toString());
}catch(Exception e){
	e.printStackTrace();
	JsonObject employee=new JsonObject();
	employee.addProperty("value",false);
}
%>