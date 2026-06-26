<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

	<%
	String username = (String) session.getAttribute("username");
	
	if(username == null){
	
	    response.sendRedirect("login.jsp");
	    return;
	
	}
	%>

	<div class="container">
		<h1>Welcome, <%= username %> !</h1>

		<p>You have successfully logged in.</p>
		
		<a href="LogoutServlet" class="logout-btn">Logout</a>
	</div>

</body>
</html>