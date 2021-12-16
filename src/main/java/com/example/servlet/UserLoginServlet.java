package com.example.servlet;

import com.example.entity.User;
import com.example.repo.UserRepository;
import com.example.security.TokenGenerator;
import com.example.service.ApplicationUtils;
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

    private final TokenGenerator tokenGen = ContextLoaderListener.getCurrentWebApplicationContext().getBean(TokenGenerator.class);

    public UserLoginServlet() {
        super();
        log.info("constructor executed");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");


        UserRepository userRepository = ContextLoaderListener.getCurrentWebApplicationContext().getBean(UserRepository.class);

        try {
            User user = userRepository.checkLogin(login, password);
            String destPage = "login.jsp";

            if (user != null) {
                log.info("user '{}' logged in successfully", login);

                ApplicationUtils.storeLoginedUser(request.getSession(), userRepository);
                String token = tokenGen.GetToken(user.getId(), user.getLogin(), user.getRole());
                ApplicationUtils.storeLoginedUserJwt(request.getSession(), token);

                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "views/home.jsp";
            } else {
                log.warn("the user '{}' with password'{}' login FAILED", login, password);
                String message = "Неверный логин или пароль : Invalid login/password";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
