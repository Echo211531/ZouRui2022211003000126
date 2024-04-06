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
//        ServletContext servletContext =this.getServletContext();
//        String driver=servletContext.getInitParameter("driver");
//        String url= "jdbc:mysql://localhost:3306/userdb?characterEncoding=utf-8&serverTimezone=UTC";
//        String username=servletContext.getInitParameter("username");
//        String password=servletContext.getInitParameter("password");
//        try {
//            Class<?> aClass = Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException e ) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        con = (Connection) getServletContext().getAttribute("con"); //从应用域取出con连接
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
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
               req.setAttribute("id",rs.getInt("id"));
               req.setAttribute("username",rs.getString("username"));
               req.setAttribute("password",rs.getString("password"));
               req.setAttribute("email",rs.getString("email"));
               req.setAttribute("gender",rs.getString("gender"));
               req.setAttribute("birthdate",rs.getString("birthdate"));

               req.getRequestDispatcher("userInfo.jsp").forward(req,resp);  //请求转发到userInfo.jsp
            }else{
                req.setAttribute("message","Username or Password Error!!!");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }

        } catch (SQLException | ServletException e) {
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
