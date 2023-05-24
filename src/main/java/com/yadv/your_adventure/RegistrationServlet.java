package com.yadv.your_adventure;

import com.yadv.your_adventure.account.SignUpForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String email = request.getParameter("text_field");
        System.out.println(email);
        SignUpForm signUpForm = new SignUpForm(request.getParameter("handle_text_field"),
                request.getParameter("name_text_field"),
                request.getParameter("surname_text_field"),
                request.getParameter("email_text_field"),
                request.getParameter("password_text_field"),
                request.getParameter("confirmed_password_text_field"));
        LoadUsersData();
        request.setAttribute("handle", signUpForm.getHandle());
        request.getRequestDispatcher("/community.jsp").forward(request, response);
    }

    void LoadUsersData() {

    }
}
