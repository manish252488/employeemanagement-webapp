<%@page import="ems.functions.EmsImages"%>
<%@page import="org.hibernate.hql.internal.ast.util.ASTUtil.IncludePredicate"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.query.NativeQuery"%>
<%@page import="ems.functions.DateTime"%>
<%@page import="java.sql.Date"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.orm.hibernate5.HibernateTemplate"%>
<%@page import="ems.model.Attendence"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isThreadSafe="true" session="true" isELIgnored="false"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>employee attendence</title>
	<link href="style/Common.css" rel="stylesheet" type="text/css">
	<link href="style/atendcss.css" rel="stylesheet" type="text/css">
	<link href="<%=EmsImages.getMainIconPath()%>" rel="icon" type="png/jpg">
<script src="scripts/jquery.js"></script>
<script src="scripts/common.js"></script>
</head>
<% 
String file="";
if(session.getAttribute("role")==null)
	response.sendRedirect("index");
String role=(String)session.getAttribute("role");

if(role.equalsIgnoreCase("adminpanel"))
file="main.jsp";
else
file="main2.jsp";

%>
<jsp:include page="<%=file %>"></jsp:include>

<body>

<%! 
ApplicationContext ctx=new ClassPathXmlApplicationContext("HibernateTemplate.xml");
HibernateTemplate template=(HibernateTemplate)ctx.getBean("template");
Session sess;
Transaction tx;
%>
<div id="panel2">
	<div class="blocks">
		<%
	//present date
	int empid=(Integer)session.getAttribute("empid");

	String q="select day,hoursWorked,intime,outtime from attendence_log where empid=:empid AND day=:day";
	sess=template.getSessionFactory().openSession();
	tx=sess.beginTransaction();
	@SuppressWarnings("unchecked")
	NativeQuery<Object[]> query=sess.createNativeQuery(q);
	query.setParameter("empid",empid);
	query.setParameter("day",DateTime.getCurrentDate());
	List<Object[]> object=(List<Object[]>)query.list();
	tx.commit();
	if(object.isEmpty()){
		out.print("mark attendence");
		out.print("<button onclick=\"window.location='addAttendence'\">click</button>");
	}else
	for(Object[] col :object)
	{
		
		//if the day is same
		if((col[0].toString()).equalsIgnoreCase(DateTime.getCurrentDate()))
		{
			if(col[3]==null){
				out.print("complete shift");
				out.print("<button onclick=\"window.location='completeshift'\">click</button>");
			}else{
				out.print("Shift completed");
			}
		}
		else{
			out.print("mark attendence");
			out.print("<button onclick=\"window.location='addAttendence'\">click</button>");
		}
		break;
	}
	%>
	</div>
	
	
	<div>
		<a href="applyleave">apply for leave</a>
	</div>
	<div>
		<table>
		<caption>salary status</caption>
		<tr></tr>
		</table>
	</div>
</div>
<div id="panel3">
	<table id="tableAtend">
		<tr id="month">
			<td>month</td>
			
		</tr>

	</table>
</div>
</body>
</html>