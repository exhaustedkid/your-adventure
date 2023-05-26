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
}
