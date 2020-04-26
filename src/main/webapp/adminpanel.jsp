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
<title>Insert title here</title>
</head>
<link href="style/panel.css" type="text/css" rel="stylesheet">
<link href="style/Common.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/employee.js"></script>

<script type="text/javascript" src="scripts/graphics.js"></script>
<meta charset="UTF-8">
<title>admin</title>
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
<div id="record1">

</div>
<div id="record2"></div>
<div id="record3"></div>
<div>

<span>report month<input type="text" name="month"></span>
<span>year<input type="text" name="year"></span>
<button class="link-btn">generate Report</button>
</div>
</article>
</fieldset>
<fieldset class="content">
<legend>employee status</legend>
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