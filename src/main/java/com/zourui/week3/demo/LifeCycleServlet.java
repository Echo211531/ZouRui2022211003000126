package com.zourui.week3.demo;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class LifeCycleServlet extends HttpServlet {
    public LifeCycleServlet(){
        System.out.println("i am in constructor --> LifeCycleServlet() ");
    }
    @Override
    public void init(){
        System.out.println("i am in init() ");
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("i am in service() --> doGet() ");
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    public void destroy() {
        System.out.println("i am in destroy() ");
    }
}
