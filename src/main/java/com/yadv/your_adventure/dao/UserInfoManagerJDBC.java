package com.yadv.your_adventure.dao;

import com.yadv.your_adventure.account.LoginForm;
import com.yadv.your_adventure.account.SignUpForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserInfoManagerJDBC {
    public static void InsertUser(SignUpForm form) {
        Connection c = null;
        try {
            c = ConnectionPool.getConnection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            String sql;
            sql = "INSERT INTO user_info(handle, email, name, surname, password) VALUES ("
                    + "\047" + form.getHandle() + "\047" + ", "
                    + "\047" + form.getEmail() + "\047" + ", "
                    + "\047" + form.getName() + "\047" + ", "
                    + "\047" + form.getSurname() + "\047" + ", "
                    + "\047" + form.getPassword() + "\047" + ");";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static LoginForm GetLoginForm(String handle) {
        Connection c = null;
        try {
            c = ConnectionPool.getConnection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_info WHERE handle = " + "\047" + handle + "\047;");
            if (rs.next()) {
                return new LoginForm(rs.getString("handle"), rs.getString("password"));
            }
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return new LoginForm(null, null);
    }
}

