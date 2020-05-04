<%@page import="org.hibernate.hql.internal.ast.util.ASTUtil.IncludePredicate"%>
<%@page import="ems.model.Employee"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.orm.hibernate5.HibernateTemplate"%>

<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%
    String role=(String)session.getAttribute("role");
    if(!role.equalsIgnoreCase("employeepanel")){
    	response.sendRedirect("login.jsp");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<link href="style/panel.css" type="text/css" rel="stylesheet">
<link href="style/Common.css" type="text/css" rel="stylesheet">
<link href="<%=EmsImages.getMainIconPath()%>" rel="icon" type="png/jpg">
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/employee.js"></script>

<meta charset="UTF-8">
<title>Employee</title>
</head>
<%@include file="main2.jsp" %>
<body>
<div id="updatepanel"><%@include file="changepassword.jsp" %></div>	

<div id="links">
<button onclick="window.location='profile'">profile</button>
<button onclick="window.location='attendence.jsp'">attendence</button>
<button onclick="window.location='projectmanager.jsp'">projects</button>
<button onclick="window.location='chatbox.jsp'">chat</button>
<button onclick="window.location='uploadfile.jsp'">upload</button>
<button onclick="window.location='viewmsg'">messages</button>
</div>
<section>
<aside>${role}</aside>
<article>article</article>
<article>article</article>
</section>
</body>

</html>