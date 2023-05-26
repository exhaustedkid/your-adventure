package com.yadv.your_adventure.dao;

import java.sql.Connection;
import java.sql.Statement;

public class TableFabricJDBC {
    public static void CreateUserInfoTable(String table_name) {
        Connection c = null;
        try {
            c = ConnectionPool.getConnection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            String sql;
            sql = "CREATE TABLE user_info (\n" +
                    "    user_id SERIAL PRIMARY KEY,\n" +
                    "    handle TEXT,\n" +
                    "    email TEXT,\n" +
                    "    password TEXT,\n" +
                    "    name TEXT,\n" +
                    "    surname TEXT\n" +
                    ");";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public static void CreateImagesTable(String table_name) {
        Connection c = null;
        try {
            c = ConnectionPool.getConnection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            String sql;
            sql = "CREATE TABLE image (\n" +
                    "    image_id SERIAL PRIMARY KEY,\n" +
                    "    image_code TEXT,\n" +
                    "    user_id INT\n" +
                    "    publish_date TIMESTAMP\n" +
                    ");";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

}
