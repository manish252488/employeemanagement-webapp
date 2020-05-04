
<%@page import="ems.functions.EmsImages"%>
<%@page import="portal.security.MyKey"%>
<%@page import="portal.security.Decrypt"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="ems.model.Employee"%>
<%@page import="org.springframework.orm.hibernate5.HibernateTemplate"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" isELIgnored="false" session="true"%>
 <%
    if(session.getAttribute("empid")==null){
    response.sendRedirect("index.jsp");
    }else{
    	int empid=(Integer)session.getAttribute("empid");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link href="style/Common.css" type="text/css" rel="stylesheet">
<link href="style/profile.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/common.js"></script>
<link href="<%=EmsImages.getMainIconPath()%>" rel="icon" type="png/jpg">
</head>
<body>
<jsp:include page="main.jsp"></jsp:include>
<section>
<div class="maincontainer1">
<fieldset><legend class="title">image</legend>
<img src="icons/home.png" class="image" id="image">
</fieldset>
<fieldset><legend class="title">adhar</legend>
<img src="icons/home.png" class="image" id="adhar">
</fieldset>
<fieldset><legend class="title">pan</legend>
<img src="icons/home.png" class="image" id="pan">
</fieldset>




</div>
<div class="maincontainer">
<div id="bar"></div>
<fieldset class="container">
<legend>Employee detail</legend>
<table>
<tr>
<% Employee emp=(Employee)request.getAttribute("emp"); %>
<td>name</td><td>${emp.getName().getFname()} ${emp.getName().getMname()} ${emp.getName().getLname()}</td></tr>
<tr><td>emp id</td><td>${emp.getEmpid()}</td><td>sex</td><td>${emp.getSex()}</td></tr>
<tr><td>mobile no1</td><td>${emp.getPhoneno1()}</td><td>mobile no2</td><td>${emp.getPhoneno2()}</td></tr>
<tr><td>adhar no</td><td>
<% out.print(Decrypt.decrypt(emp.getAdhar(),MyKey.getKey())); %></td>
<td>pancard no</td><td>
<% out.print(Decrypt.decrypt(emp.getPanno(),MyKey.getKey()));  %></td></tr>

</table>
</fieldset>
<fieldset class="container"><legend>${emp.getName().getFname()}'s Location</legend>
<table>
<tr><td>State:</td><td>${emp.getAdd().getState()}</td><td>City:</td><td>${emp.getAdd().getCity()}</td></tr>
<tr><td>address</td></tr>
<tr>
<td></td><td>${emp.getAdd().getAddress1()},${emp.getAdd().getAddress2()}</td>
</tr>
<tr><td>birth-date</td><td>${emp.getBirthdate()}</td><td>email</td><td>${emp.getEmail()}</td></tr>
</table>
</fieldset>
<fieldset class="container"><legend> Department</legend>
<table>
<tr><td>deptId:</td><td>${emp.getDept().getDeptid()}</td><td>department</td><td>${emp.getDept().getDeptname()}</td></tr>
<tr><td>job</td><td>${emp.getJob()}</td></tr>

<tr><td>department head<td>${emp.getDept().getDepartmentHead()}</td><td>location</td><td>${emp.getDept().getLocation()}</td></tr>
<tr><td>code</td><td>${emp.getDept().getCode()}</td></tr>

</table>
</fieldset>
<fieldset class="container"><legend>salary</legend>
<table>
<tr><td>Salary:</td><td>${emp.getSal().getSalary() }</td><td>Bonus:</td><td>${emp.getSal().getBonus()}</td></tr>
<tr><td>Account no</td><td>
<% out.print(Decrypt.decrypt(emp.getSal().getAccno(),MyKey.getKey())); %>
</td><td>bank name</td><td>${emp.getSal().getBank_name()}</td></tr>
<tr><td>Ifsc code</td><td>
<% out.print(Decrypt.decrypt(emp.getSal().getIfsccode(), MyKey.getKey())); %></td></tr>
<tr><td>salary status</td>
<td>
<%
if(!emp.getSal().isStatus())
out.print("Admin");
else 
out.print("employee");
%></td></tr>

</table>
</fieldset>
</div>
</section>
</body>
</html>