<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	session.invalidate(); // infalida a sess�o do usuario
	response.sendRedirect("login.html");
%>