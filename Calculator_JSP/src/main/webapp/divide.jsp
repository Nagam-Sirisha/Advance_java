<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@ include file="nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int square = (int)session.getAttribute("square");
	int divide = square/2;
	out.println("<h1>Divide by 2 is: "+divide+"</h1>");
%>
</body>
</html>