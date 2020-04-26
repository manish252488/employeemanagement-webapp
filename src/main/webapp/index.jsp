<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style/index.css" rel="stylesheet" type="text/css">
<link href="style/Common.css" rel="stylesheet" type="text/css">
<script src="scripts/jquery.js"></script>
<script src="scripts/common.js"></script>
</head>
<body>
<header id="mainheader">
<img src="icons/main.png" class="headericon">
<div id="title">hello</div>
<div>

<%
String role=(String)session.getAttribute("role");
if(session.getAttribute("empid")==null){
out.print("<button onclick=\"window.location='login.jsp'\" class='link-btn'>login</button>");

}else
{
	out.print("<button onclick=\"window.location='"+role+".jsp'\" class='link-btn'>profile</button>");
out.print("<button onclick=\"window.location='logout.jsp'\" class='link-btn'>logout</button>");
}
 %>
 </div>


</header>
<div id="mainbody">
<div style="background:#333"></div>
<div style="background:green"></div>
</div>
</body>
</html>