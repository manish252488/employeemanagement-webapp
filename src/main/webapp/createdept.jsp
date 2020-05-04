<%@page import="ems.functions.EmsImages"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%!String title="Create Department"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ems-<%=title %></title>
<link href="style/Common.css" type="text/css" rel="stylesheet">
<link href="<%=EmsImages.getMainIconPath()%>" rel="icon" type="png/jpg">
<script src="scripts/jquery.js"></script>
<script src="scripts/common.js"></script>
<script src="scripts/script2.js"></script>

<style>
fieldset{
max-width:80%;
height:25vw;
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
table
{
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
input[type=text]
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
<%@ include file="main.jsp" %>
<body>
<fieldset>
<legend>Department</legend>
<form action="createdept" method="post" onsubmit="return validateform()">
<table>
<tr></tr>
<tr><td>department name</td><td><input type="text" name="deptname" onblur="checkname(this.value)" required></td>
<td class="errors" id="err"></td></tr>
<tr><td>department head</td><td><input type="text" name="depthead" onblur="validate2(this.value)" required></td>
<td class="errors" id="err2"></td></tr>
<tr><td>location</td><td><input type="text" name="deptloc" onblur="validate3(this.value)" required></td>
<td class="errors" id="err3"></td></tr>
<tr><td><input type="submit" value="update" class="btnu btn-grad "></td>
</tr>

</table>

</form>
</fieldset>

</body>
</html>