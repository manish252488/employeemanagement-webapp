<%@page import="ems.functions.EmsImages"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>upload file</title>
<link href="style/Common.css" type="text/css" rel="stylesheet">
<link href="style/uploadform.css" type="text/css" rel="stylesheet">
<link href="<%=EmsImages.getMainIconPath()%>" rel="icon" type="png/jpg">
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/common.js"></script>
</head>
<jsp:include page="main.jsp"></jsp:include>
<body>
<fieldset id="uploadfile">
<legend>uploadfile</legend>
<form action="uploadempdet" method="post"  enctype="multipart/form-data">
<label class="lab">Employee Id</label>
<input type="text" name="empid" value="${empid}" oninput="empDetails(this.value)" onblur="empDetails(this.value)" required>
<label id="empname"></label>
<label class="lab">image</label><input type="file" name="image" class="fileupload"  required>
<label class="lab">adhar card</label><input type="file" name="adhar" class="fileupload" required>
<label class="lab">pan card</label><input type="file" name="pan" class="fileupload" required>
<input type="submit" value="upload" class="link-btn btn">
</form>
</fieldset>
<div id="imagecontainer">
<div></div>
<div></div>
<div></div>
</div>
</body>
</html>