package com.yadv.your_adventure;

import com.yadv.your_adventure.account.LoginForm;
import com.yadv.your_adventure.account.SignUpForm;
import com.yadv.your_adventure.dao.PictureManagerJDBC;
import com.yadv.your_adventure.dao.UserInfoManagerJDBC;
import javafx.util.Pair;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Objects;

public class Controller {

    static final int count_pictures_on_page = 3;

    public enum CONFIGURE_PAGE_MODE {
        profile,
        community
    }

    public static void ConfigurePage(RequestContainer request, CONFIGURE_PAGE_MODE mode) {
        String page_info = request.request.getParameter("page");
        int page = 0; // here page 0-indexed
        if (page_info != null) {
            page = Integer.parseInt(page_info);
        }
        ArrayList<Pair<String, String>> images = new ArrayList<>();
        if (mode == CONFIGURE_PAGE_MODE.community) {
            images = PictureManagerJDBC.GetPictures(page * count_pictures_on_page, count_pictures_on_page);
        }
        if (mode == CONFIGURE_PAGE_MODE.profile) {
            images = PictureManagerJDBC.GetUserPictures(request.request.getParameter("handle"), page * count_pictures_on_page, count_pictures_on_page);
        }
        request.request.setAttribute("page", ++page);
        request.request.setAttribute("handle", request.request.getParameter("handle"));
        if (images.size() < 1) {
            return;
        }
        request.request.setAttribute("pic1", images.get(0).getKey());
        request.request.setAttribute("handle1", images.get(0).getValue());
        if (images.size() < 2) {
            return;
        }
        request.request.setAttribute("pic2", images.get(1).getKey());
        request.request.setAttribute("handle2", images.get(1).getValue());
        if (images.size() < 3) {
            return;
        }
        request.request.setAttribute("pic3", images.get(2).getKey());
        request.request.setAttribute("handle3", images.get(2).getValue());
    }

    public static class RequestContainer {
        public HttpServletRequest request;

        public RequestContainer(HttpServletRequest request) {
            this.request = request;
        }
    }

    public static void SavePicture(String image, String handle, String date) {
        PictureManagerJDBC.SavePicture(image, handle, date);
    }

    public static LoginForm GetLoginForm(String handle) {
        return UserInfoManagerJDBC.GetLoginForm(handle);
    }

    public static boolean VerifyEmail(LoginForm loginForm) {
        LoginForm requested = UserInfoManagerJDBC.GetLoginForm(loginForm.getHandle());
        if (requested.getHandle() == null) {
            return false;
        }
        return Objects.equals(requested.getPassword(), loginForm.getPassword());
    }

    public static int GetPicturesCount(String handle) {
        return PictureManagerJDBC.GetPicturesCount(handle);
    }
}
