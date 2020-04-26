<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="com.google.gson.stream.JsonReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="ems.functions.FileCreater"%>
<%@page import="java.io.Reader"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
JsonArray arr=(JsonArray)request.getAttribute("msglist");
out.print(arr);
%>
</body>
</html>