package com.example.servlet;

import com.example.service.ApplicationUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jwt")
public class JwtToken extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public JwtToken() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String token = ApplicationUtils.getLoginedUserJwt(request.getSession());
        PrintWriter writer = response.getWriter();
        writer.println(token);
    }

}
