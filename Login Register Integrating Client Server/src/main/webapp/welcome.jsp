<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>

<body>

<%
String username = (String) session.getAttribute("username");

if(username == null){

    response.sendRedirect("login.jsp");
    return;

}
%>

<h2>Welcome <%= username %></h2>

<br><br>

<a href="LogoutServlet">Logout</a>

</body>
</html>