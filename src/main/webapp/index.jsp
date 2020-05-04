<%@page import="ems.functions.DateTime"%>
<%@page import="ems.functions.EmsImages"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMPLOYEE ADMINSTRATION SYSTEM</title>
<link href="<%=EmsImages.getMainIconPath()%>" rel="icon" type="png/jpg">
<link href="style/index.css" rel="stylesheet" type="text/css">
<link href="style/Common.css" rel="stylesheet" type="text/css">
<script src="scripts/jquery.js"></script>
<script src="scripts/common.js"></script>
<style>
#datedisp{
position: fixed;
right:0;
top: 50%;
background: tomato;
border-radius: 1vw;
padding:0.5vw;
border: 0.1vw solid #fff;
font-size: 1.5vw;
font-wight:bold;
color:#fff;
cursor:pointer;
}
</style>
</head>
<body>
<span id="datedisp">
<%=DateTime.getCurrentTime()%>
</span>
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
<div style="background:green" >
</div>
</div>


<section class="des">
<article>
Mark Elliot Zuckerberg is an American technology entrepreneur and philanthropist.
Zuckerberg is known for co-founding and leading Facebook as its chairman and chief executive officer.
He also co-founded and is a board member of the solar sail spacecraft development project Breakthrough Starshot.
Born in White Plains,
</article>
<article>
Mark Elliot Zuckerberg is an American technology entrepreneur and philanthropist.
Zuckerberg is known for co-founding and leading Facebook as its chairman and chief executive officer.
He also co-founded and is a board member of the solar sail spacecraft development project Breakthrough Starshot.
Born in White Plains,
</article>
<article>
Mark Elliot Zuckerberg is an American technology entrepreneur and philanthropist.
Zuckerberg is known for co-founding and leading Facebook as its chairman and chief executive officer.
He also co-founded and is a board member of the solar sail spacecraft development project Breakthrough Starshot.
Born in White Plains,
</article>

</section>
<section class="des">
<article>
Mark Elliot Zuckerberg is an American technology entrepreneur and philanthropist.
Zuckerberg is known for co-founding and leading Facebook as its chairman and chief executive officer.
He also co-founded and is a board member of the solar sail spacecraft development project Breakthrough Starshot.
Born in White Plains,
</article>
<article>
Mark Elliot Zuckerberg is an American technology entrepreneur and philanthropist.
Zuckerberg is known for co-founding and leading Facebook as its chairman and chief executive officer.
He also co-founded and is a board member of the solar sail spacecraft development project Breakthrough Starshot.
Born in White Plains,
</article>
<article>
Mark Elliot Zuckerberg is an American technology entrepreneur and philanthropist.
Zuckerberg is known for co-founding and leading Facebook as its chairman and chief executive officer.
He also co-founded and is a board member of the solar sail spacecraft development project Breakthrough Starshot.
Born in White Plains,
</article>

</section>
<footer></footer>
</body>
</html>