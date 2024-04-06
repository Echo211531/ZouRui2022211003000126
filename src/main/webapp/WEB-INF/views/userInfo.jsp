
<%@ page import="com.zourui.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    Cookie[] cookies = request.getCookies();
    for(Cookie c:cookies){
        out.println("<br>"+c.getName()+"---"+c.getValue());
    }
%>
<%
    User u=(User) request.getAttribute("user");
%>
<table>
<tr>
    <td>Username：</td><td><%=u.getUsername()%></td>
<tr></tr>
    <td>Password：</td><td><%=u.getPassword()%></td>
<tr></tr>
    <td>Email：</td><td><%=u.getEmail()%></td>
<tr></tr>
    <td>Gender：</td><td><%=u.getGender()%></td>
<tr></tr>
    <td>Birth Date：</td><td><%=u.getBirthdate()%></td>
<tr></tr>
</tr>
</table>
<a href="updateUser.jsp">Click here to update</a>
<%@include file="footer.jsp"%>