package com.zourui.week5.demo;

import com.zourui.week2.demo.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HelloServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        ServletContext servletContext =this.getServletContext();
        String driver=servletContext.getInitParameter("driver");
        String url= "jdbc:mysql://localhost:3306/userdb?characterEncoding=utf-8&serverTimezone=UTC";
        String username=servletContext.getInitParameter("username");
        String password=servletContext.getInitParameter("password");
        try {
            Class<?> aClass = Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e ) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String sql="select * from usertable where username=?and password=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String username1 = resultSet.getString("username");
                String password1 = resultSet.getString("password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = resp.getWriter();
        if(username!=null&&password!=null){
            resp.setContentType("text/html");
            out.println("<h2>Login Success!!!</h2>");
            out.println("<h2>Welcome "+username+"</h2>");
        }else{
            out.println("Username or Password Error!!!");
        }
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
