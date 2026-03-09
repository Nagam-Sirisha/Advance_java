<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="red">
 <%--  <%= exception.getMessage() %>  --%>
 
 <%if(response.getStatus()==500)
	 {%>
 <h1>Internal server error</h1>
 <%}else{ %>
 <h1>Something went wrong!!</h1>
 <%} %>
</body>
</html>