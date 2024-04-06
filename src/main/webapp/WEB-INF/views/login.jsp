<%--
  Created by IntelliJ IDEA.
  User: www21
  Date: 2024/3/28
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
    if(!(request.getAttribute("message")==null)){  //如果message不为空
        out.println(request.getAttribute("message"));
    }

%>
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
        <%
            if(!(request.getAttribute("message")==null)){
                out.println(request.getAttribute("message"));
            }
        %>
        <%
            Cookie[] cookies = request.getCookies();  //接收后端cookie
            String username="",password="",rememberMeval="";
            if(cookies!=null){
                for(Cookie c:cookies){
                    if(c.getName().equals("cUsername")){
                        username=c.getValue();
                    }
                    if(c.getName().equals("cPassword")){
                        password=c.getValue();
                    }
                    if(c.getName().equals("cRememberMe")){
                        rememberMeval=c.getValue();
                    }
                }
            }
        %>
        <form action="login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="<%=username%>" required>
            <label for="password" >Password:</label>
            <input type="password" id="password" name="password" value="<%=password%>" required>
            <br>
            <input type="checkbox" name="rememberMe" value="1" <%=rememberMeval.equals("1")?"checked":""%>checked/>RememberMe<br/>
            <button type="submit">Login</button>
        </form>
    </div>
</div>
<%--</body>--%>
<%--</html>--%>
<%@include file="footer.jsp"%>