 <%@page import="ems.functions.EmsImages"%>
<%@page import="ems.model.Employee"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>spouse</title>
<link href="style/Common.css" type="text/css" rel="stylesheet">
<link href="<%=EmsImages.getMainIconPath()%>" rel="icon" type="png/jpg">
<script src="scripts/jquery.js"></script>
<script src="scripts/common.js"></script>
<script src="scripts/script2.js"></script>
<style type="text/css">
fieldset{
max-width:80%;
margin:auto;
padding:2vw;
}
legend{
margin:auto;
font-size:2vw;
letter-spacing:0.3vw;
color:tomato;
font-weight:bolder;
}
table{
width:90%;
margin:auto;
}
tr,td
{
text-align:left;
font-size:1.2vw;
color:#fff;
text-transform:uppercase;
font-weight:bold;
padding:1vw;
}
input[type=text],input[type=email]
{
padding:0.5vw;
border-radius:1vw;
border:0.2vw solid #fff;
background:#333;
color:#fff;
font-weight:300;
width:100%;
}
input[type=text]:hover
{
background:#ddd;
color:#333;
}
.errors
{
width:30vw;
color:tomato;
font-weight:regular;
}


</style>
</head>
<%@include file="main.jsp" %>
<body>
		<fieldset>
		<form action="addmember" method="post">
		<table>
		<tr><td>employee id</td><td><input type="text" name="empid" value="${empid}" required></td></tr>
		<tr><td>name</td><td><input type="text" name="name" required onblur="validate2(this.value)"></td><td class="errors" id="err2"></td></tr>
		<tr><td>mobile no</td><td><input type="text" name="phno" required onblur="validate2(this.value)"></td><td class="errors"></td></tr>
		<tr><td>relation with employee</td><td><input type="text" name="relation" required onblur="validate2(this.value)"></td></tr>
		<tr><td>adhar no</td><td><input type="text" name="adharno" required></td><td class="errors"></td></tr>
		<tr><td>Email </td><td><input type="email" name="email" required></td></tr>
		<tr><td></td><td><input type="submit" value="update" class="btnu btn-grad "></td>
		
		</tr>
		
		</table>
			</form>
	<button onclick="window.location='index.jsp'" id="skip" class="btnu btn-grad">skip</button>
	</fieldset>
</body>
</html>