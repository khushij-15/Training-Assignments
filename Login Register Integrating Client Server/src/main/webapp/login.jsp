<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>

<body>

    <h2>Login</h2>

    <form action="LoginServlet" method="post">

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
                <td><label for="password">Password: </label></td>
                <td>
                    <input type="password"
                        id="password"
                        name="password"
                        placeholder="Enter Password">
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

</body>
</html>