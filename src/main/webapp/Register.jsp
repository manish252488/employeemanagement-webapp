<%@page import="ems.functions.EmsImages"%>
<%@page import="org.springframework.orm.hibernate5.HibernateTemplate"%>
<%@page import="org.hibernate.query.NativeQuery"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page session="true" autoFlush="true"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ems-Register Employee</title>
<link href="style/Common.css" type="text/css" rel="stylesheet">
<link href="style/registerpage.css" type="text/css" rel="stylesheet">
<link href="<%=EmsImages.getMainIconPath()%>" rel="icon" type="png/jpg">
<script src="scripts/jquery.js"></script>
<script src="scripts/script2.js"></script>
<script src="scripts/common.js"></script>
</head>
<%! 
String url="register";
String display="none";
String btnval="";
%>

<%
// if(!((String)session.getAttribute("role")).equalsIgnoreCase("adminpanel") || session.getAttribute("role")==null){
// 	response.sendRedirect("index.jsp");
// }

boolean updateflag=Boolean.parseBoolean(request.getParameter("u"));
if(updateflag){
url="updateemp";
display="block";
btnval="update";
}
else{
	url="register";
 display="none";
 btnval="Register";
}
%>
<%@ include file="main.jsp" %>
		<body>
		<fieldset id="registerform">
		<legend><%=btnval%> Employee</legend>
		
		
		
		<form action="<%=url %>" method="post" >
		<table>	
		<tr>	<td style="display:<%=display%>">Employee Id:</td><td><input type="text" style="display:<%=display%>" name="empid" onblur="setFields(this.value)" placeholder="enter employee Id to begin"></td></tr>
		<tr>	<td style="display:<%=display%>">salid Id:</td><td><input type="text" style="display:<%=display%>" name="salid" readonly="readonly"></td>	<tr>
		

		<tr><td>search department</td><td><input type="text" name="deptname"  onkeyup="searchdepartment(this.value)" oninput="hide()" id="deptname">
		<div id="searchresult"></div></td></tr><tr><td>dept code:</td><td>
		<select oninput="setDept(this.value)" name="selectdept" id="selectdept">
		<%! ApplicationContext ctx; %>
		<%
		try{
			ctx=new ClassPathXmlApplicationContext("HibernateTemplate.xml");
			HibernateTemplate s=(HibernateTemplate)ctx.getBean("template");
			@SuppressWarnings("unchecked")
		NativeQuery<Object[]> q=s.getSessionFactory().openSession().createNativeQuery("select deptid,code from Department");

		List<Object[]> department=(List<Object[]>)q.list();

		for(Object[] dept:department)
		out.print("<option value='"+dept[0]+"'>"+dept[1]+"</option>");
		}catch(Exception e){e.printStackTrace();out.print("<option>null</option>");}
		%>
		</select>
		</td>
		<td>department id</td>
		<td><input type="text" name="dept" id="dept" required></td></tr>
		<tr><td>first name</td>
		<td><input type="text" name="fname" required></td>
		<td>middle name</td>
		<td><input type="text" name="mname"></td>
		<td>last NAME</td>
		<td><input type="text" name="lname" required></td>
		</tr><tr><td>Birthdate</td><td><input type="date" name="bdate" max="2019-12-31"></td>
		</tr><tr><td>sex</td><td><input type="radio" name="sex" value="m" checked>male</td>
		<td><input type="radio" name="sex" value="f">female</td></tr>
		<tr><td>phone no</td><td><input type="text" name="phno1"></td><td>mobile no</td>	
		<td><input type="text" name="phno2"></td><td>email</td><td><input type="email" name="email" required>
		</tr><tr><td>salary</td><td>
		<input type="text" name="salary" required></td>
		<td>bonus</td><td>
		<input type="text" name= "bonus" required></td>
		</tr><tr><td>job</td><td><input type="text" name="job" required></td></tr><tr>
		<td>address</td><td><input type="text" name="add1" required></td>
		<td><input type="text" name="add2"></td>
		</tr><tr><td>state</td><td><input type="text" name="state" required></td>
		<td>city</td><td><input type="text" name="city" required></td>
		<td>pincode/postalcode</td><td><input type="text" name="pincode" required></td></tr>
		<tr><td>accno</td><td><input type="text" name="accno" required></td>
		<td>bank ifsc</td><td><input type="text" name="ifsc" required></td><td>bank name</td>
		<td><input type="text" name="bank_name" required></td></tr>
		<tr><td>adharno</td><td><input type="text" name="adharno" required></td>
		<td>pan no</td><td><input type="text" name="panno" required></td>
		</tr>
		
		<tr><td>admin</td><td><input type="radio" name="admin" value="true">yes</td><td><input type="radio" name="admin" value="false" checked>no</td></tr>
		<tr><td></td><td></td><td></td><td></td><td><input type="reset" value="reset" class="reg btn-grad"></td><td>
		
		<input type="submit" value="<%=btnval %>" class="reg btn-grad"></td></tr>
	</table>
</form>
	</fieldset>
</body>

</html>