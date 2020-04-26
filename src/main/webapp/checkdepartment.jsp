
<%@page import="ems.model.Department"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="org.springframework.orm.hibernate5.HibernateTemplate"%>
<%@page import="org.hibernate.query.NativeQuery"%>
<%@page import="ems.functions.GetFirstChar"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.service.ServiceRegistry"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%! ApplicationContext ctx; %>
<%
String s=request.getParameter("x");
// String s="cse";
s=s.toLowerCase();
String code=GetFirstChar.getString(s);
try{
	ctx=new ClassPathXmlApplicationContext("HibernateTemplate.xml");
	HibernateTemplate ses=(HibernateTemplate)ctx.getBean("template");
	@SuppressWarnings("unchecked")
	NativeQuery<Department> q=ses.getSessionFactory().openSession().createNativeQuery("select * from Department where code=:i");
	q.setParameter("i",code);
	List<Department> l=q.list();
	JsonObject jsobj=new JsonObject();
	if(l.isEmpty())
	jsobj.addProperty("value",true);
	else
	jsobj.addProperty("value",false);
	out.print(jsobj);
	}catch(Exception e){
	ctx=null;
	JsonObject jsobj=new JsonObject();
	jsobj.addProperty("value",false);
	out.print(jsobj);
	e.printStackTrace();
}

%>