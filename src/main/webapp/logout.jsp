<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
session.removeAttribute("empid");
session.removeAttribute("role");
response.sendRedirect("index.jsp");
%>