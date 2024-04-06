package com.zourui.week6.demo;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.annotation.WebListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener    //域监听器，初始化JDBC
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContext servletContext =sce.getServletContext();
        String driver=servletContext.getInitParameter("driver");
        String url= "jdbc:mysql://localhost:3306/userdb?characterEncoding=utf-8&serverTimezone=UTC";
        String username=servletContext.getInitParameter("username");
        String password=servletContext.getInitParameter("password");
        try {
            Connection con=null;
            Class<?> aClass = Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("i am in contextInitialized()");
//            System.out.println("--> "+con);
        } catch (ClassNotFoundException e ) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("i am in contextDestroyed()");
        sce.getServletContext().removeAttribute("con");  //关闭连接

    }
}
