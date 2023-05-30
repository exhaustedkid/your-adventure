package com.yadv.your_adventure;

import com.yadv.your_adventure.account.LoginForm;
import com.yadv.your_adventure.dao.PictureManagerJDBC;
import com.yadv.your_adventure.dao.UserInfoManagerJDBC;
import javafx.util.Pair;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet("/sign_in")
public class VerificationServlet extends HttpServlet {
    static final Logger logger = Logger.getLogger(VerificationServlet.class);
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
        logger.log(Level.INFO, "Starting verifying e-mail");
        if (Controller.VerifyEmail(loginForm)) {
            logger.log(Level.INFO, "Set Attributes");
            request.setAttribute("handle", loginForm.getHandle());
            request.setAttribute("page", 0); // 0-indexed
            logger.log(Level.INFO, "Creating Controller.RequestContainer");
            Controller.RequestContainer container = new Controller.RequestContainer(request);
            Controller.ConfigurePage(container, Controller.CONFIGURE_PAGE_MODE.community);
            String jsp = "/community.jsp";
            logger.log(Level.WARN, "forwarding to" + jsp);
            request.getRequestDispatcher(jsp).forward(request, response);
        }
        else {
            logger.log(Level.WARN, "The password is incorrect");
            request.setAttribute("login_status", "Wrong handle or password");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}