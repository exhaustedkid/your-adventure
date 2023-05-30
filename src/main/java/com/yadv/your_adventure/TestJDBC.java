package com.yadv.your_adventure;

import com.yadv.your_adventure.dao.ConnectionPool;
import com.yadv.your_adventure.dao.PictureManagerJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

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
//
//            sql = "CREATE TABLE user_info (\n" +
//                    "    user_id SERIAL PRIMARY KEY,\n" +
//                    "    handle TEXT,\n" +
//                    "    email TEXT,\n" +
//                    "    password TEXT,\n" +
//                    "    name TEXT,\n" +
//                    "    surname TEXT\n" +
//                    ");";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO user_info VALUES (3, 'zolodimos', 'dr@mail.ru', 'Dmitry', 'Rubin');";
//            stmt.executeUpdate(sql);
//
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
//
//            sql = "CREATE TABLE image (\n" +
//                    "    image_id SERIAL PRIMARY KEY,\n" +
//                    "    image_code TEXT,\n" +
//                    "    user_id INT,\n" +
//                    "    publish_date TIMESTAMP\n" +
//                    ");";
//            stmt.executeUpdate(sql);
//
//
//            sql = "DROP TABLE image;";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO image(image_code, user_id, publish_date) VALUES " +
//                    "('img1', 1, '2023-04-12 05:02:05'), " +
//                    "('img2', 1, '2023-04-13 07:02:05'), " +
//                    "('img3', 2, '2023-04-14 05:02:05'); ";
//            stmt.executeUpdate(sql);
//
//            PictureManagerJDBC.SavePicture("asdasd", "egor", "2023-04-12 05:02:05");

//            String image = "LOOOOOOl22";
//            String date = "2023-04-12 05:02:05";


//            sql = "DELETE FROM image WHERE image_code NOT LIKE 'data%';";
//            stmt.executeUpdate(sql);

//            sql = "INSERT INTO image(image_code, user_id, publish_date) VALUES " +
//                    "(" + "\047" + image + "\047" + ", " + "\047" + UserInfoManagerJDBC.GetUserId(handle) + "\047" + ", " + "\047" + date + "\047" + ");";
//                    "(" + "\047" + image + "\047" + ", " + "\047" + 1 + "\047" + ", " + "\047" + date + "\047" + ");";
//                        stmt.executeUpdate(sql);

//            String s = "pic";
//            String date = "2023-04-12 05:02:05";
//            String handle = "111";
//            PictureManagerJDBC.SavePicture(s, handle, date);
//
//            Object o = PictureManagerJDBC.GetPictures(0, 3);
//
//            ResultSet rs = stmt.executeQuery("SELECT * FROM image ORDER BY publish_date;");
//            int i = 1;
//            while (rs.next()) {
//                String image_code = rs.getString("image_code");
//                int user_id = rs.getInt("user_id");
//                System.out.println(i);
//                System.out.println("image_code = " + image_code);
//                System.out.println("user_id = " + user_id);
//                ++i;
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
