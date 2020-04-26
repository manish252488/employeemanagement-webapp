<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="org.hibernate.query.NativeQuery"%>
<%@page import="org.springframework.orm.hibernate5.HibernateTemplate"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%! ApplicationContext ctx=null; %>
<% 
String input=request.getParameter("x");
// String input="m";
ctx=new ClassPathXmlApplicationContext("HibernateTemplate.xml");
HibernateTemplate ses=(HibernateTemplate)ctx.getBean("template");
@SuppressWarnings("unchecked")
NativeQuery<Object[]> q=ses.getSessionFactory().openSession().createNativeQuery("select deptid,deptname from Department where deptname LIKE '%"+input+"%'");
List<Object[]> department=(List<Object[]>)q.list();
JsonArray jsarr=new JsonArray();

for(Object[] dept:department){
	JsonObject jsobj=new JsonObject();
	jsobj.addProperty("deptid", dept[0]+"");
	jsobj.addProperty("name",dept[1]+"");
	jsarr.add(jsobj);	
}
out.print(jsarr.toString());
%>
