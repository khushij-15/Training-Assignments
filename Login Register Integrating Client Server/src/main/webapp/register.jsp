<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/validation.js"></script>
<title>Register</title>
</head>

<body>

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
                </td>
            </tr>

            <tr>
                <td><label for="email">Email: </label></td>
                <td>
                    <input type="email"
                           id="email"
                           name="email"
                           placeholder="Enter Email">
                </td>
            </tr>

            <tr>
                <td><label for="password">Password: </label></td>
                <td>
                    <input type="password"
                           id="password"
                           name="password"
                           placeholder="Enter Password">
                </td>
            </tr>

            <tr>
                <td><label for="confirmPassword">Confirm Password: </label></td>
                <td>
                    <input type="password"
                           id="confirmPassword"
                           name="confirmPassword"
                           placeholder="Confirm Password">
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

</body>
</html>