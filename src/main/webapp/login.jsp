<%--
  Created by IntelliJ IDEA.
  User: www21
  Date: 2024/3/28
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
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
        <h2>New User Login</h2>
        <form action="login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <br>
            <button type="submit">Login</button>
        </form>
    </div>
</div>
<%--</body>--%>
<%--</html>--%>
<%@include file="footer.jsp"%>