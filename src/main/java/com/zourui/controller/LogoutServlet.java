package com.zourui.controller;
import com.zourui.week2.demo.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/logout")
public class LogoutServlet extends HelloServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();//kill session
        req.setAttribute("messsage","you have successfully Logged out.");
        try {
            req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
}
