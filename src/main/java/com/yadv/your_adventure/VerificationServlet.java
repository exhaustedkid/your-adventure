package com.yadv.your_adventure;

import com.yadv.your_adventure.account.LoginForm;
import com.yadv.your_adventure.db.UserInfoManagerJDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/sign_in")
public class VerificationServlet extends HttpServlet {
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
        LoginForm loginForm = new LoginForm(request.getParameter("hande_text_field"),
                request.getParameter("password_text_field"));
        if (VerifyEmail(loginForm)) {
            request.setAttribute("handle", loginForm.getHandle());
            request.getRequestDispatcher("/community.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/index.jsp").forward(request, response); // tryagain.jsp
        }
    }

    boolean VerifyEmail(LoginForm loginForm) {
        LoginForm requested = UserInfoManagerJDBC.GetLoginForm(loginForm.getHandle());
        if (requested.getHandle() == null) {
            return false;
        }
        return Objects.equals(requested.getPassword(), loginForm.getPassword());
    }
}