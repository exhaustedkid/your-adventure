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


@WebServlet("/profile")
public class UserPageServlet extends HttpServlet {
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
        String page_info = request.getParameter("page");
        int page = 1;
        if (!page_info.isEmpty()) {
            page = Integer.parseInt(page_info);
        }
        ArrayList<Pair<String, String>> images = PictureManagerJDBC.GetUserPictures(request.getParameter("handle"), (page - 1) * count, count);
        request.setAttribute("page", ++page);
        request.setAttribute("handle", request.getParameter("handle"));
        request.setAttribute("pic1", images.get(0).getKey());
        request.setAttribute("pic2", images.get(1).getKey());
        request.setAttribute("pic3", images.get(2).getKey());

//        Controller.ConfigurePage(request, Controller.CONFIGURE_PAGE_MODE.profile);    sweat_dreams

        request.setAttribute("pictures_count", PictureManagerJDBC.GetPicturesCount(request.getParameter("handle")));
        request.getRequestDispatcher("/your_works.jsp").forward(request, response);
    }
}