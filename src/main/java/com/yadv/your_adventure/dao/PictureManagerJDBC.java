package com.yadv.your_adventure.dao;

import javafx.util.Pair;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PictureManagerJDBC {
    public static ArrayList<Pair<String, String>> GetPictures(int from, int count) {
        Connection c = null;
        ArrayList<Pair<String, String>> images_and_handles = new ArrayList<>();
        try {
            c = ConnectionPool.getConnection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM image INNER JOIN user_info USING(user_id) ORDER BY publish_date LIMIT " + count + "OFFSET " + from + ";");
            while (rs.next()) {
                images_and_handles.add(new Pair<>(rs.getString("image_code"), rs.getString("handle")));
            }
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return images_and_handles;
    }

    public static ArrayList<Pair<String, String>> GetUserPictures(String handle, int from, int count) {
        Connection c = null;
        ArrayList<Pair<String, String>> images_and_handles = new ArrayList<>();
        try {
            c = ConnectionPool.getConnection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM image INNER JOIN user_info USING(user_id) " +
                    "WHERE handle = " + "\047" + handle + "\047" + " ORDER BY publish_date LIMIT " + count + "OFFSET " + from + ";");
            while (rs.next()) {
                images_and_handles.add(new Pair<>(rs.getString("image_code"), rs.getString("handle")));
            }
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return images_and_handles;
    }


    public static int GetPicturesCount(String handle) {
        int count = 0;
        Connection c = null;
        try {
            c = ConnectionPool.getConnection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS cnt FROM image INNER JOIN user_info USING(user_id) WHERE handle = " + "\047" + handle + "\047;");
            while (rs.next()) {
                count = rs.getInt("cnt");
            }
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return count;
    }

    public static void SavePicture(String image, String handle, String date) {
        Connection c = null;
        try {
            c = ConnectionPool.getConnection();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            String sql;
            sql = "INSERT INTO image(image_code, user_id, publish_date) VALUES ("
                    + "\047" + image + "\047" + ", "
                    + "\047" + UserInfoManagerJDBC.GetUserId(handle) + "\047" + ", "
                    + "\047" + date + "\047" + ");";
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
}
