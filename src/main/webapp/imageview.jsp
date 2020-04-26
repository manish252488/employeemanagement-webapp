
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="image/jpeg"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
this is an image of yours
<% 

byte[] b=(byte[])request.getAttribute("b");
OutputStream os=response.getOutputStream();
BufferedOutputStream bos=new BufferedOutputStream(os);
bos.write(b);
bos.flush();
bos.close();
os.flush();
os.close();

%>


</body>
</html>