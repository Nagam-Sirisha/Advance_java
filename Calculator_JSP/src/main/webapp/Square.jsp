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
<%int sum =(int) session.getAttribute("sum");
int square=sum*sum;
out.println("<h1>Square is: "+square+"</h1>");
%>

<form action="divide.jsp">
<button>Divide</button>
</form>
<%session.setAttribute("square", square); %>
</body>
</html>