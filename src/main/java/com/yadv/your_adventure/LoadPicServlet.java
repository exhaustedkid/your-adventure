package com.yadv.your_adventure;

import com.yadv.your_adventure.dao.PictureManagerJDBC;
import javafx.util.Pair;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/save")
@MultipartConfig(maxFileSize = 16177215)
public class LoadPicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletInputStream stream = request.getInputStream();

        int c = 0;
        StringBuilder handle = new StringBuilder();

        while (true) {
            c = stream.read();
            if (c == 10) break;
            handle.append((char)c);
        } // c != (int)'\n'

        c = 0;
        StringBuilder date = new StringBuilder();
        while (true) {
            c = stream.read();
            if (c == 10) break;
            date.append((char)c);
        } // c != (int)'\n'

        byte[] buf = new byte[128];
        ByteArrayOutputStream bufOut = new ByteArrayOutputStream();
        for (int bytesRead = 0; bytesRead != -1; bytesRead = stream.read(buf)) {
            bufOut.write(buf, 0, bytesRead);
        }

        Controller.SavePicture(bufOut.toString(), handle.toString(), date.toString());
    }
}
