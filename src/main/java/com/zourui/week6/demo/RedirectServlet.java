package com.zourui.week6.demo;

import com.zourui.week2.demo.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/redirect")
public class RedirectServlet extends HelloServlet {
    @Override
    public void init() throws ServletException {}
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("before redirect ");
        resp.sendRedirect("index.jsp");   //url
        System.out.println("after redirect ");
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
}
