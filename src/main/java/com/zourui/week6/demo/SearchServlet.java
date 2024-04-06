package com.zourui.week6.demo;

import com.zourui.week2.demo.HelloServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/search")
public class SearchServlet extends HelloServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String txt = req.getParameter("txt");
        if(txt == null){
            resp.sendRedirect("index.jsp");
        }else{
            if(req.getParameter("search").equals("baidu")){
                resp.sendRedirect("https://www.baidu.com/s?wd="+txt);
            }
            if(req.getParameter("search").equals("bing")){
                resp.sendRedirect("https://cn.bing.com/search?q="+txt);
            }
            if(req.getParameter("search").equals("google")){
                resp.sendRedirect("https://www.google.com/search?q="+txt);
            }
        }

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
}
