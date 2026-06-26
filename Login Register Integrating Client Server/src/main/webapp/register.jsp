<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/validation.js"></script>
<link rel="stylesheet" href="css/style.css">
<title>Register</title>
</head>

<body>
	<%
	String error = (String) request.getAttribute("error");
	
	if(error != null){
	%>
	
	<p style="color:red;"><%= error %></p>
	
	<%
	}
	%>

    <div class="container">
    	<h2>User Registration</h2>

	    <form action="RegisterServlet" method="post" onsubmit="validateRegister()">
	
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
	                <td><label for="email">Email: </label></td>
	                <td>
	                    <input type="email"
	                           id="email"
	                           name="email"
	                           placeholder="Enter Email">
                        <span id="emailError" class="field-error"></span>
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
	                <td><label for="confirmPassword">Confirm Password: </label></td>
	                <td>
	                    <input type="password"
	                           id="confirmPassword"
	                           name="confirmPassword"
	                           placeholder="Confirm Password">
                        <span id="confirmPasswordError" class="field-error"></span>
	                </td>
	            </tr>
	
	            <tr>
	                <td colspan="2" align="center">
	                    <button type="submit">Register</button>
	                </td>
	            </tr>
	
	        </table>
	
	    </form>
	
	    <br>
	
	    <p>
	        Already have an account?
	        <a href="login.jsp">Login Here</a>
	    </p>
    </div>

</body>
</html>