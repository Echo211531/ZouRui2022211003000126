package com.zourui.week4.demo;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/jdbc")
public class RegisterServlet extends HttpServlet{
    Connection con=null;

    @Override
    public void init() throws ServletException {
//        ServletContext servletContext =this.getServletContext();
//        String driver=servletContext.getInitParameter("driver");
//        String url= "jdbc:mysql://localhost:3306/userdb?characterEncoding=utf-8&serverTimezone=UTC";
//        String username=servletContext.getInitParameter("username");
//        String password=servletContext.getInitParameter("password");
//        try {
//            Class<?> aClass = Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//            System.out.println("--> "+con);
//        } catch (ClassNotFoundException e ) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        con = (Connection) getServletContext().getAttribute("con"); //从应用域取出con连接


    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String gender=req.getParameter("gender");
        String birthdate=req.getParameter("birthdate");
        String sql="insert into usertable(username,password,email,gender,birthdate) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,gender);
            preparedStatement.setString(5,birthdate);
            int i = preparedStatement.executeUpdate();


//            String sql1="select * from usertable";
//            ResultSet rs = preparedStatement.executeQuery(sql1);
//            req.setAttribute("rsname",rs);
//            // 获取输出流
//            PrintWriter out = resp.getWriter();
//            req.getRequestDispatcher("userList.jsp").forward(req,resp);

            //注册成功则跳转到登录页面
            resp.sendRedirect("login.jsp");







        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        resp.setContentType("text/html");


          // 写入HTML头部
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>用户信息表</title>");
//        out.println("<style>");
//        out.println("table { width: 100%; border-collapse: collapse; }");
//        out.println("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
//        out.println("</style>");
//        out.println("</head>");
//        out.println("<body>");
//
//        // 写入表格
//        out.println("<h2>用户信息表</h2>");
//        out.println("<table>");
//        out.println("<tr>");
//        out.println("<th>ID</th>");
//        out.println("<th>UserName</th>");
//        out.println("<th>PassWord</th>");
//        out.println("<th>Email</th>");
//        out.println("<th>Gender</th>");
//        out.println("<th>Birthdate</th>");
//        out.println("</tr>");
//
//        // 第一行数据
//        out.println("<tr>");
//        out.println("<td>1</td>");
//        out.println("<td>"+username+"</td>");
//        out.println("<td>"+password+"</td>");
//        out.println("<td>"+email+"</td>");
//        out.println("<td>"+gender+"</td>");
//        out.println("<td>"+birthdate+"</td>");
//        out.println("</tr>");
//        // 写入表格结束
//        out.println("</table>");
//        // 写入HTML尾部
//        out.println("</body>");
//        out.println("</html>");
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


