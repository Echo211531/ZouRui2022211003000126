<%--
  Created by IntelliJ IDEA.
  User: www21
  Date: 2024/4/17
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/views/header.jsp"%>
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
<h1>User Update</h1>
<%
    User u=(User) session.getAttribute("user");
%>
<div class="container">
    <div class="form">
        <h2>User Update</h2>
        <form action="updateUser" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username"value=<%=u.getUsername()%> required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value=<%=u.getPassword()%> required>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value=<%=u.getEmail()%> required>
            <label>Gender:</label>
            <input type="radio" id="male" name="gender" value="male" <%="male".equals(u.getGender())?"checked":""%>required>
            <label for="male">Male</label>
            <input type="radio" id="female" name="gender" value="female"<%="female".equals(u.getGender())?"checked":""%>>
            <label for="female">Female</label>
            <br>
            <label for="birthdate">Birthdate (yyyy-mm-dd):</label>
            <input type="text" id="birthdate" name="birthdate" placeholder="e.g., 1990-01-01" value=<%=u.getBirthdate()%> required>
            <br>
            <button type="submit">Save Changes</button>
        </form>
    </div>
</div>

<%@include file="WEB-INF/views/footer.jsp"%>