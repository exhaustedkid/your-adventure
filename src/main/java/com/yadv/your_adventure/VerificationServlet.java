package com.yadv.your_adventure;

import com.yadv.your_adventure.account.LoginForm;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign_in")
public class VerificationServlet extends HttpServlet {
    static Logger logger = LogManager.getLogger(Controller.class);
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.log(Level.INFO, "doGet method called");
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.log(Level.INFO, "doPost method called");
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoginForm loginForm = new LoginForm(request.getParameter("hande_text_field"),
                request.getParameter("password_text_field"));
        logger.log(Level.INFO, "try to log in");
        if (Controller.VerifyLoginForm(loginForm)) {
            logger.log(Level.INFO, "Setting 'handle' and 'page' attributes");
            request.setAttribute("handle", loginForm.getHandle());
            request.setAttribute("page", 0); // 0-indexed
            logger.log(Level.INFO, "controller proceeding");
            Controller.RequestContainer container = new Controller.RequestContainer(request);
            Controller.ConfigurePage(container, Controller.CONFIGURE_PAGE_MODE.community);
            request.setAttribute("handle", loginForm.getHandle()); // bad
            logger.log(Level.INFO, "forwarding to community.jsp");
            request.getRequestDispatcher("/community.jsp").forward(request, response);
        }
        else {
            request.setAttribute("login_status", "Wrong handle or password");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}