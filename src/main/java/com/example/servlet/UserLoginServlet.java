package com.example.servlet;

import com.example.entity.User;
import com.example.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.ContextLoaderListener;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/login")
@Slf4j
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserLoginServlet() {
        super();
        log.info("constructor executed");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("username");
        String password = request.getParameter("password");


        UserRepository userRepository = ContextLoaderListener.getCurrentWebApplicationContext().getBean(UserRepository.class);

        try {
            User user = userRepository.checkLogin(login, password);
            String destPage = "login.jsp";

            if (user != null) {
                log.info("user '{}' logged in successfully", login);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "views/home.jsp";
            } else {
                log.warn("the user '{}' with password'{}' login FAILED", login, password);
                String message = "Неверный логин или пароль : Invalid username/password";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
