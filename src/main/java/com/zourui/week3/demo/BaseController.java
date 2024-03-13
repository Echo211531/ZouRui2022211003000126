package com.zourui.week3.demo;

import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Date date=new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = format.format(date);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("Name:zourui");
        writer.write("<br/>Id:2022211003000126");
        writer.write("<br/>Date and Time "+date1);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp)  {

    }
}