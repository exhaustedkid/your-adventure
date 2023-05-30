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
//        System.out.println("id param = " + request.getParameter("page"));

        ServletInputStream stream = request.getInputStream();

//        ByteArrayOutputStream bufOutHandle = new ByteArrayOutputStream();
//        byte[] handle_buf = new byte[128];
//        bufOutHandle.write(stream.read(handle_buf), 0, ;

        int c = 0;
        StringBuilder handle = new StringBuilder();

        while (c != 10) {
            c = stream.read();
            handle.append((char)c);
        }; // c != (int)'\n'

//        c = 0;
        StringBuilder date = new StringBuilder();
//        date.append(stream.read());
//        date.append(stream.read());
//        date.append(stream.read());
//        date.append(stream.read());
        // year
//        stream.read();
//        stream.read();
        // - (45 ind)

        byte[] buf = new byte[128];
        ByteArrayOutputStream bufOut = new ByteArrayOutputStream();
        for (int bytesRead = 0; bytesRead != -1; bytesRead = stream.read(buf)) {
            bufOut.write(buf, 0, bytesRead);
        }
        System.out.println(handle);
        System.out.println(date);
        System.out.println(bufOut);
//        PictureManagerJDBC.SavePicture(bufOut.toString(), "egor", "2023-04-12 05:02:05");



        request.getRequestDispatcher("/community.jsp").forward(request, response);
    }
}
