<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String username=request.getParameter("username");
String password=request.getParameter("password");
Cookie ck= new Cookie("Username",username);
Cookie ck1=new Cookie("Password",password);
response.addCookie(ck);
response.addCookie(ck1);
RequestDispatcher rd=request.getRequestDispatcher("TP4Assign1");
rd.forward(request,response);
%>

</body>
</html>