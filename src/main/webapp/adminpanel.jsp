<%@page import="ems.functions.EmsImages"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String role=(String)session.getAttribute("role");
    if(!role.equalsIgnoreCase("adminpanel")){
    	response.sendRedirect("login.jsp");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${role}</title>
</head>
<link href="style/panel.css" type="text/css" rel="stylesheet">
<link href="style/Common.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/employee.js"></script>
<script type="text/javascript" src="scripts/graphics.js"></script>
<link href="<%=EmsImages.getMainIconPath()%>" rel="icon" type="png/jpg">
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
<div id="updatepanel"><%@include file="changepassword.jsp" %></div>	
<%@include file="main.jsp" %>
<div id="links">
<button onclick="window.location='profile'">profile</button>
<button onclick="window.location='attendence.jsp'">attendence</button>
<button onclick="window.location='projectmanager.jsp'">projects</button>
<button onclick="window.location='chatbox.jsp'">chat</button>
<button onclick="window.location='uploadfile.jsp'">upload</button>
</div>
<section>
<fieldset class="content">
<legend>employee status</legend>
<article class="article">
<div id="record1"></div>
<div id="record2"></div>
<div id="record3"></div>
</article>
</fieldset>
<fieldset class="content">
<legend>projects status</legend>
<article class="article">
status report

</article>
</fieldset>
<fieldset class="content">
<legend>employee status</legend>
<article class="article">

</article>
</fieldset>
<fieldset class="content">
<legend>employee status</legend>
<article class="article">
status report

</article>
</fieldset>
</section>
</body>
</html>