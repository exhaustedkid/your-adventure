package com.yadv.your_adventure;

import com.yadv.your_adventure.dao.PictureManagerJDBC;

import javafx.util.Pair;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/load")
public class PageServlet extends HttpServlet {
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

    static final int count = 3;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controller.RequestContainer container = new Controller.RequestContainer(request);
        Controller.ConfigurePage(container, Controller.CONFIGURE_PAGE_MODE.community);
        request.getRequestDispatcher("/community.jsp").forward(request, response);
    }
}