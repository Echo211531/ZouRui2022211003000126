<%--
  Created by IntelliJ IDEA.
  User: www21
  Date: 2024/3/7
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/views/header.jsp"%>
<%--<html>--%>
<%--<meta charset="UTF-8">--%>
<%--<head>--%>
<%--    <title>User Login</title>--%>
<%--</head>--%>
<%--<body>--%>
<style>
    body {
        font-family: Arial, sans-serif;
        text-align: center;
    }
    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .form {
        width: 300px;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #f9f9f9;
    }
    .form label {
        display: block;
        margin-bottom: 10px;
    }
    .form input[type="text"],
    .form input[type="password"],
    .form input[type="email"] {
        width: 80%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }
    .form input[type="radio"] {
        margin-right: 5px;
    }
    .form button {
        width: 100%;
        padding: 10px;
        background-color: orange;
        color: #fff;
        border: none;
        border-radius: 3px;
        cursor: pointer;
    }
</style>
<div class="container">
    <div class="form">
        <h2>New User Registration</h2>
        <form action="jdbc" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            <label>Gender:</label>
            <input type="radio" id="male" name="gender" value="male" required>
            <label for="male">Male</label>
            <input type="radio" id="female" name="gender" value="female">
            <label for="female">Female</label>
            <br>
            <label for="birthdate">Birthdate (yyyy-mm-dd):</label>
            <input type="text" id="birthdate" name="birthdate" placeholder="e.g., 1990-01-01" required>
            <br>
            <button type="submit">Register</button>
        </form>
    </div>
</div>
<%--</body>--%>
<%--</html>--%>
<%@include file="WEB-INF/views/footer.jsp"%>