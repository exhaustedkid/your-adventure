package com.yadv.your_adventure;

import com.yadv.your_adventure.dao.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String args[]) {
        Connection c = null;
        try {
            c = ConnectionPool.getConnection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            String sql;

//            sql = "DROP TABLE user_info;";
//            stmt.executeUpdate(sql);

//            sql = "CREATE TABLE user_info (\n" +
//                    "    user_id SERIAL PRIMARY KEY,\n" +
//                    "    handle TEXT,\n" +
//                    "    email TEXT,\n" +
//                    "    password TEXT,\n" +
//                    "    name TEXT,\n" +
//                    "    surname TEXT\n" +
//                    ");";
//            stmt.executeUpdate(sql);

//            sql = "INSERT INTO user_info VALUES (3, 'zolodimos', 'dr@mail.ru', 'Dmitry', 'Rubin');";
//            stmt.executeUpdate(sql);

//            ResultSet rs = stmt.executeQuery("SELECT * FROM user_info;");
//            while (rs.next()) {
//                int id = rs.getInt("user_id");
//                String name = rs.getString("name");
//                String surname = rs.getString("surname");
//                String handle = rs.getString("handle");
//                String email = rs.getString("email");
//                String password = rs.getString("password");
//                System.out.println("ID = " + id);
//                System.out.println("HANDLE = " + handle);
//                System.out.println("NAME = " + name);
//                System.out.println("SURNAME = " + surname);
//                System.out.println("EMAIL = " + email);
//                System.out.println("PASSWORD = " + password);
//                System.out.println();
//            }
            c.commit();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
