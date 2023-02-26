package com.nebrija.coleccionista.controller.authentication;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        String user = request.getParameter("userName");
        String password = request.getParameter("userPass");

        if (password.equals("admin") && user.equals("admin")) {
            session.setAttribute("user", user);
            response.sendRedirect("welcome.jsp?user=" + user);
        }
        else {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            out.println("<font color=red>CONTRASEÑA INCORRECTA.</font>");
            rd.include(request, response);
        }
        out.close();
    }
}
