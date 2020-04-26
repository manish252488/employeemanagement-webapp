<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="style/Common.css" rel="stylesheet" type="text/css">
<link href="style/project.css" type="text/css" rel="stylesheet">
	<script src="scripts/jquery.js"></script>
	<script src="scripts/common.js"></script>
</head>
<body>
<section class="box">
	
	<div>
		<form action="" method="post">
		<label class="lab">project name</label><input type="text" class="inputfield" name="projectname">
		<label class="lab">project location</label><input type="text" class="inputfield" name="ploc">
		<label class="lab">client name</label><input type="text" class="inputfield" name="clentname">
		<label class="lab">clients company</label><input type="text" class="inputfield" name="company">
		<label class="lab">due date</label><input type="date" class="inputfield" name="due date">
		<label class="lab">no of members required</label><input type="text" class="inputfield" name="no_mem">
		<input type="submit" class="btnu btn-grad lab" value="upload">
		
		
		</form>
	</div>
	<div id="fileupload">
	<div id="dropbox" ondrop="upload(event)">+</div>
	</div>
	</section>
</body>
</html>