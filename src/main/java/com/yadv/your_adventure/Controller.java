package com.yadv.your_adventure;

import com.yadv.your_adventure.dao.PictureManagerJDBC;
import javafx.util.Pair;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class Controller {

    static final int count_pictures_on_page = 3;

    public enum CONFIGURE_PAGE_MODE {
        profile,
        community
    }
    public static void ConfigurePage(HttpServletRequest request, CONFIGURE_PAGE_MODE mode) {
        System.out.println("on configure page");
        System.out.println(request.getParameter("handle"));
        String page_info = request.getParameter("page");
        int page = 0;
        if (page_info != null) {
            page = Integer.parseInt(page_info);
        }
        ArrayList<Pair<String, String>> images = new ArrayList<>();
        if (mode == CONFIGURE_PAGE_MODE.community) {
            images = PictureManagerJDBC.GetPictures(page * count_pictures_on_page, count_pictures_on_page);
        }
        if (mode == CONFIGURE_PAGE_MODE.profile) {
            images = PictureManagerJDBC.GetUserPictures(request.getParameter("handle"), page * count_pictures_on_page, count_pictures_on_page);
        }
        if (images.size() < 3) {
            System.out.println(images.size());
            return;
        }
        request.setAttribute("page", ++page);
        request.setAttribute("handle", request.getParameter("handle"));
        request.setAttribute("pic1", images.get(0).getKey());
        request.setAttribute("handle1", images.get(0).getValue());
        request.setAttribute("pic2", images.get(1).getKey());
        request.setAttribute("handle2", images.get(1).getValue());
        request.setAttribute("pic3", images.get(2).getKey());
        request.setAttribute("handle3", images.get(2).getValue());
    }
}
