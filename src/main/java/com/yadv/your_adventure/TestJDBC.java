package com.yadv.your_adventure;

import com.yadv.your_adventure.dao.ConnectionPool;

import java.sql.Connection;
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

//            sql = "CREATE TABLE image (\n" +
//                    "    image_id SERIAL PRIMARY KEY,\n" +
//                    "    image_code TEXT,\n" +
//                    "    user_id INT,\n" +
//                    "    publish_date TIMESTAMP\n" +
//                    ");";
//            stmt.executeUpdate(sql);

//            sql = "INSERT INTO image(image_code, user_id, publish_date) VALUES" +
//                    "('img1', 1, '2023-04-12 05:02:05'), " +
//                    "('img2', 1, '2023-04-13 07:02:05'), " +
//                    "('img3', 2, '2023-04-14 05:02:05'), " +
//                    "('img4', 3, '2023-04-15 05:02:05'), " +
//                    "('img5', 3, '2023-04-16 05:02:05'), " +
//                    "('img6', 2, '2023-04-09 05:02:05'), " +
//                    "('img7', 2, '2023-04-08 05:02:05'), " +
//                    "('img8', 1, '2023-04-07 05:02:05'); ";
//            stmt.executeUpdate(sql);
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
