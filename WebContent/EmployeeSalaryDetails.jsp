<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Salary Details</title>
</head>
<body>
<%
String salary=(String)session.getAttribute("salary");
String acctype=(String)session.getAttribute("acctype");
%>
Salary: Rs. <%=salary %> <br>
Salary Account type: <%=acctype %>
</body>
</html>