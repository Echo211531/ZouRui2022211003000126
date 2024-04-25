package com.zourui.controller;
import com.zourui.dao.IUserDaoImpl;
import com.zourui.model.User;
import com.zourui.util.DateUtil;
import com.zourui.week2.demo.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HelloServlet{
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con"); //从应用域取出con连接
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session= req.getSession();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String gender=req.getParameter("gender");
        String birthdate=req.getParameter("birthdate");
        Date date = DateUtil.convertStringToUtil(birthdate);
        User user=new User(username,password,email,gender,date);
        try {
            int a = 0;
            a = new IUserDaoImpl().updateUser(con, user);
            if(a!=0){
                session.setAttribute("user",user);
                req.setAttribute("user",user);
                req.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(req,resp);  //请求转发到userInfo.jsp
                }
            }catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }
}


