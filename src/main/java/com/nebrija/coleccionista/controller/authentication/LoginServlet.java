package com.nebrija.coleccionista.controller.authentication;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        String user = request.getParameter("userName");
        String password = request.getParameter("userPass");

        if (password.equals("admin") && user.equals("admin")) {
            session.setAttribute("user", user);
            response.sendRedirect("management.jsp?user=" + user);

        }

        else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
            //response.sendRedirect("index.jsp");
            out.println("<script src=\"scripts/incorrect.js\"></script>");
        }
        out.close();
    }
}
