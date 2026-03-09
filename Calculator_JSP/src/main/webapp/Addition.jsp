<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int num1=Integer.parseInt(request.getParameter("n1"));
int num2=Integer.parseInt(request.getParameter("n2"));
int sum = num1+num2;
out.println("<h1>Sum is :- "+sum+"</h1>");
%>
<form action="Square.jsp">
<button>Square</button>
</form>
<% session.setAttribute("sum",sum); %>
</body>
</html>