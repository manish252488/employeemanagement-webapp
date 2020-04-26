<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>login page</title>
	<link href="style/loginpage.css" type="text/css" rel="stylesheet">
	<link href="style/Common.css" type="text/css" rel="stylesheet">
	<script src="scripts/jquery.js"></script>
	<script src="scripts/common.js"></script>
	<script src="scripts/loginpage.js"></script>
	<meta http-equiv="refresh" content="1000">
</head>
<body>
<header>
<img src="icons/main.png" class="headericon">
<div id="title">hello</div>
<div><button onclick="window.location='index.jsp'" class="link-btn"><img alt="home" src="icons/home.png" class="btnicons"></button></div>
</header>
	<div id="errorpanel">im an error</div>
<div id="loginpanel">
<%
if(session.getAttribute("empid")!=null){
response.sendRedirect(session.getAttribute("role")+".jsp");
}
%>
	<fieldset>
		<legend>loginpage</legend>
		<form action="login" method="post" onsubmit="return validate()">
			<label class="labels">Employee id</label>
			<input type="text" name="empid" class="fields" oninput="error(this.value)" required>
				<label class="labels">Password</label>
			<input type="Password" name="password" class="fields" required>
			<input type="submit" Value="login" class="btn">
			
		</form>
<a href="forgotpassword.jsp" >Forgot Password</a> 
	</fieldset>
</div>
</body>
</html>