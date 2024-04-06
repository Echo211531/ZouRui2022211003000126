package com.zourui.week5.demo;

import com.zourui.dao.IUserDaoImpl;
import com.zourui.model.User;
import com.zourui.week2.demo.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user = null;
        try {
            user = new IUserDaoImpl().findByUsernamePassword(con, username, password);

        if(user!=null){
            String rememberMe=req.getParameter("rememberMe");
            if(rememberMe!=null&&rememberMe.equals("1")){
                Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);
                usernameCookie.setMaxAge(5);
                passwordCookie.setMaxAge(5);
                rememberMeCookie.setMaxAge(5);
                resp.addCookie(usernameCookie);
                resp.addCookie(passwordCookie);
                resp.addCookie(rememberMeCookie);
            }
            HttpSession session=req.getSession();
            System.out.println("session id-->"+session.getId());
            session.setMaxInactiveInterval(10);
            session.setAttribute("user",user);
            req.setAttribute("user",user);
            req.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(req,resp);  //请求转发到userInfo.jsp
            }else{
                req.setAttribute("message","Username or Password Error!!!");
                req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
            }
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
//        PrintWriter out = resp.getWriter();
//        if(user.getUsername()!=null&&user.getPassword()!=null){
//            resp.setContentType("text/html");
//            out.println("<h2>Login Success!!!</h2>");
//            out.println("<h2>Welcome "+user.getUsername()+"</h2>");
//        }else{
//            out.println("Username or Password Error!!!");
//        }
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
