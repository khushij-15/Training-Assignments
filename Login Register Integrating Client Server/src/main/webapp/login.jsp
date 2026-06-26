<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/validation.js"></script>
<link rel="stylesheet" href="css/style.css">
<title>Login</title>
</head>

<body>

    <div class="container">
    <%
	String error = (String) request.getAttribute("error");
	
	if(error != null){
	%>
	
	<p style="color:red;"><%= error %></p>
	
	<%
	}
	%>
    	<h2>Login</h2>

	    <form action="LoginServlet" method="post" onSubmit="return validateLogin()">
	
	        <table>
	
	            <tr>
	                <td><label for="username">Username: </label></td>
	                <td>
	                    <input type="text"
	                        id="username"
	                        name="username"
	                        placeholder="Enter Username">
	                    <span id="usernameError" class="field-error"></span>
	                </td>
	            </tr>
	
	            <tr>
	                <td><label for="password">Password: </label></td>
	                <td>
	                    <input type="password"
	                        id="password"
	                        name="password"
	                        placeholder="Enter Password">
                        <span id="passwordError" class="field-error"></span>
	                </td>
	            </tr>
	
	            <tr>
	                <td colspan="2" align="center">
	                    <button type="submit">Login</button>
	                </td>
	            </tr>
	
	        </table>
	
	    </form>
	
	    <br>
	
	    <p>
	        New User?
	        <a href="register.jsp">Register Here</a>
	    </p>
    	
    </div>
</body>
</html>