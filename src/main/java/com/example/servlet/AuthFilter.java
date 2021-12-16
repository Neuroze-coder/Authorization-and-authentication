package com.example.servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/views/*")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        String loginURL = request.getContextPath() + "/login";
        String registrationURL = request.getContextPath() + "/registration";

        boolean loggedIn = session != null && session.getAttribute("user") != null;

        boolean loginRequest = request.getRequestURI().equals(loginURL) || request.getRequestURI().equals(loginURL + ".html");
        boolean registrationRequest = request.getRequestURI().equals(registrationURL) || request.getRequestURI().equals(registrationURL + ".html");

        if (loggedIn || loginRequest || loginRequest) {
            chain.doFilter(req, resp);
        }
        else {
            response.sendRedirect("/TaskAuth_war_exploded/login.jsp");
        }
    }
}
