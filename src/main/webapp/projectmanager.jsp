<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    String role=(String)session.getAttribute("role");
    if(!role.equalsIgnoreCase("adminpanel")){
    	session.removeAttribute("empid");
    	response.sendRedirect("login.jsp");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ems-projects</title>
<link href="style/project.css" type="text/css" rel="stylesheet">
<link href="style/Common.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/common.js"></script>

</head>
<body>
<%@include file="main.jsp" %>
<div id="link"><a href="upproject.jsp">upload a new project</a><a href="">show onprogress projects</a><a href="">completed projects</a></div>
<section class="container">
	<div id="project_status">
		<span>no of projects assigned</span><span>no of projects completed</span>
		<script type="text/javascript">
		var ele=document.createElement("canvas");
		b=ele.getContext("2d");
		ele.width=300;
		ele.height=300;
		arcpos=ele.width/2;
		radius=ele.width/3;
		b.fillStyle="transparent";
		//0-2
		endpos=1.9;
		b.fillRect(0,0,ele.width,ele.height);
		document.getElementById("project_status").appendChild(ele);
		b.lineWidth=80;
		b.strokeStyle="mediumseagreen";
		b.beginPath();
		b.arc(arcpos,arcpos,radius,Math.PI * 0.5,(endpos+0.5) * Math.PI);
		b.stroke();
		b.beginPath();
		if(endpos<2.5){
		b.strokeStyle="tomato";
		b.arc(arcpos,arcpos,radius,(endpos+0.5) * Math.PI,Math.PI * 2.5);
		b.stroke();
	}

	</script>
	</div>

	<div id="project_due">
		<span>no of projects due</span>
		<span>no of projects sold</span>
			<script type="text/javascript">
		var ele=document.createElement("canvas");
		b=ele.getContext("2d");
		ele.width=300;
		ele.height=300;
		arcpos=ele.width/2;
		radius=ele.width/3;
		b.fillStyle="#fff";
		//0-2
		endpos=1.9;
		b.fillRect(0,0,ele.width,ele.height);
		document.getElementById("project_due").appendChild(ele);
		b.lineWidth=80;
		b.strokeStyle="mediumseagreen";
		b.beginPath();
		b.arc(arcpos,arcpos,radius,Math.PI * 0.5,(endpos+0.5) * Math.PI);
		b.stroke();
		b.beginPath();
		if(endpos<2.5){
		b.strokeStyle="tomato";
		b.arc(arcpos,arcpos,radius,(endpos+0.5) * Math.PI,Math.PI * 2.5);
		b.stroke();
	}

	</script>
	</div>
	<div id="project_sucess">
			<span>no of projects due</span>
			<span>no of projects sold</span>
			<script type="text/javascript">
		var ele=document.createElement("canvas");
		b=ele.getContext("2d");
		ele.width=300;
		ele.height=300;
		arcpos=ele.width/2;
		radius=ele.width/3;
		b.fillStyle="#fff";
		//0-2
		endpos=1.9;
		b.fillRect(0,0,ele.width,ele.height);
		document.getElementById("project_sucess").appendChild(ele);
		b.lineWidth=80;
		b.strokeStyle="mediumseagreen";
		b.beginPath();
		b.arc(arcpos,arcpos,radius,Math.PI * 0.5,(endpos+0.5) * Math.PI);
		b.stroke();
		b.beginPath();
		if(endpos<2.5){
		b.strokeStyle="tomato";
		b.arc(arcpos,arcpos,radius,(endpos+0.5) * Math.PI,Math.PI * 2.5);
		b.stroke();
	}

	</script>
	</div>
</section>
</body>
</html>