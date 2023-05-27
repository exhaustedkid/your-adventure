package com.yadv.your_adventure;

import com.yadv.your_adventure.account.LoginForm;
import com.yadv.your_adventure.dao.*;
import com.yadv.your_adventure.account.SignUpForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
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
        SignUpForm signUpForm = new SignUpForm(request.getParameter("handle_text_field"),
                request.getParameter("name_text_field"),
                request.getParameter("surname_text_field"),
                request.getParameter("email_text_field"),
                request.getParameter("password_text_field"),
                request.getParameter("confirmed_password_text_field"));
        LoginForm loginForm = UserInfoManagerJDBC.GetLoginForm(signUpForm.getHandle());
        if (loginForm.getHandle() == null) {
            if (!Objects.equals(signUpForm.getPassword(), signUpForm.getConfirmedPassword())) {
                System.out.println("Passwords dont match");
                request.setAttribute("register_status", "Passwords dont match");
                request.getRequestDispatcher("/registration.jsp").forward(request, response);
            } else {
                UserInfoManagerJDBC.InsertUser(signUpForm);
                request.setAttribute("handle", signUpForm.getHandle());
                request.setAttribute("page", 1);
                request.getRequestDispatcher("/community.jsp").forward(request, response);
            }
        } else {
            System.out.println("User already exists");
            request.setAttribute("register_status", "User already exists");
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }
    }
}
