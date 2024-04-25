package com.zourui.dao;

import com.zourui.model.User;
import com.zourui.util.DateUtil;
import jakarta.servlet.ServletException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IUserDaoImpl implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        if(updateUser(con,user)==0){
            return true;
    }
        return false;
}
    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String gender = user.getGender();
        Date birthdate = user.getBirthdate();

        String sql = "delete from usertable where username=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {

        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String gender = user.getGender();
        Date birthdate = user.getBirthdate();

        String sql = "update usertable set password=?,email=?,gender=?,birthdate=? where username=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, gender);
            java.sql.Date date = DateUtil.convertUtilToSql(birthdate);
            preparedStatement.setDate(4, date);
            preparedStatement.setString(5, username);
            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "select * from usertable where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "select * from usertable where username=?and password=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }
    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "select * from usertable where username=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        ArrayList<User> arrayList=new ArrayList<>();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            arrayList.add(user);
        }
        return arrayList;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "select * from usertable where password=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        ArrayList<User> arrayList=new ArrayList<>();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            arrayList.add(user);
        }
        return arrayList;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "select * from usertable where email=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        ArrayList<User> arrayList=new ArrayList<>();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            arrayList.add(user);
        }
        return arrayList;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select * from usertable where gender=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, gender);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        ArrayList<User> arrayList=new ArrayList<>();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            arrayList.add(user);
        }
        return arrayList;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "select * from usertable where birthdate=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        ArrayList<User> arrayList=new ArrayList<>();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            arrayList.add(user);
        }
        return arrayList;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "select * from usertable";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        ArrayList<User> arrayList=new ArrayList<>();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            arrayList.add(user);
        }
        return arrayList;
    }
}
