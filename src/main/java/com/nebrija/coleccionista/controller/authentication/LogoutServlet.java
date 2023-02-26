package com.nebrija.coleccionista.controller.authentication;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LogoutServlet() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        response.setContentType("text/html");

        //Printeamos por consola la sesión antes y después de invalidarlas para ver como
        // se abre y cierra y el id de la misma.
        System.out.println("Sesión antes de invalidarla:  "+ request.getSession(false));

        request.getSession(false).invalidate();

        System.out.println("Sesión después de invalidarla: "+ request.getSession(false));

        String redirectURL = "index.jsp";

        response.sendRedirect(redirectURL);

        out.close();



    }

}
