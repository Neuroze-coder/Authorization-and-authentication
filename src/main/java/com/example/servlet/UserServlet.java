package com.example.servlet;

import com.example.entity.User;
import com.example.repo.UserRepository;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/registration")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserRepository userDAO;

    public void init() {
        userDAO = new UserRepository();
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Servlet at: ").append(req.getContextPath());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/registration.jsp");
        dispatcher.forward(req,resp);
    }

    // логин имя фамилия пароль

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("username");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");

        User user = ContextLoaderListener.getCurrentWebApplicationContext().getBean(User.class);
        user.setLogin(login);
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);

        try {
            userDAO.registrationUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("views/userdetails.jsp");
    }
}
