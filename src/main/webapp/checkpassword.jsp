<%@page import="com.google.gson.JsonObject"%>
<%@page import="org.hibernate.Session"%>
<%@page import="ems.model.Employee"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.orm.hibernate5.HibernateTemplate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%

String pass=request.getParameter("x");
int id=(Integer)session.getAttribute("empid");
ApplicationContext ctx=new ClassPathXmlApplicationContext("HibernateTemplate.xml");
HibernateTemplate template=(HibernateTemplate)ctx.getBean("template");
Session s=template.getSessionFactory().openSession();
Transaction tx=s.beginTransaction();
Employee emp=(Employee)s.get(Employee.class,id);
JsonObject json=new JsonObject();

if(pass.equals(emp.getUser().getPassword())){
	json.addProperty("value", true);
}
else
	json.addProperty("value", false);
out.print(json.toString());
%>