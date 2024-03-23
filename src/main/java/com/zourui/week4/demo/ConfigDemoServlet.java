package com.zourui.week4.demo;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet(
        urlPatterns = {"/config"},
        initParams = {@WebInitParam(name = "name1",value = "zourui"),
                @WebInitParam(name = "studentId1",value = "2022211003000126"),
                @WebInitParam(name = "name",value = "zourui"),
                @WebInitParam(name = "studentId",value = "2022211003000126")},
        loadOnStartup = 1
)
public class ConfigDemoServlet extends HttpServlet{
    Connection con=null;
    @Override
    public void init() throws ServletException {
//        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String url="jdbc:sqlserver://localhost;databaseName=userdb;";
//        String username="root";
//        String password="151212";
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//            System.out.println("--> "+con);
//        } catch (ClassNotFoundException e ) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("i am in doGet()");
//        String sql="select * from usertable";
//        try {
//            ResultSet rs = con.createStatement().executeQuery(sql);
//            while(rs.next()){
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        resp.setContentType("text/html");
        ServletConfig config=getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        String name=config.getInitParameter("name");
        String studentId=config.getInitParameter("studentId");
        resp.getWriter().println("<h2>Task 1-Get init parameters from web.xml</h2>");

        resp.getWriter().println("<br>name: "+name);
        resp.getWriter().println("<br>studentId: "+studentId);

        resp.getWriter().println("<h2>Task 1-Get init parameters from @WebServlet</h2>");
        resp.getWriter().println("<br>name1: "+name);
        resp.getWriter().println("<br>studentId1: "+studentId);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
