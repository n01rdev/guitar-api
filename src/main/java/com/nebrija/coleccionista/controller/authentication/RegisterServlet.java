package com.nebrija.coleccionista.controller.authentication;

import com.nebrija.coleccionista.dao.DBConnection;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private String getRandomString(int n) {

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index = (int)(characters.length() * Math.random());
            result.append(characters.charAt(index));
        }

        return result.toString();
    }

    public String getHashedPassword(final String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("userNameRegister");
        String passwordPlainText = request.getParameter("userPassRegister");
        //boolean isAdmin = request.getParameter("isAdmin") != null; //En Desarrollo.
        int idUser = 0; // Autoincrement en la DB.
        String passwordSalt = getRandomString(20);
        String passwordHashed = getHashedPassword(passwordPlainText + passwordSalt);

        try {
            Connection connection;
            connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into userName values(?,?,?)");
            ps.setInt(1, idUser);
            ps.setString(2, username);
            ps.setString(3, passwordHashed);
            int i = ps.executeUpdate();
            if (i > 0) {
                out.println("Registrado con éxito");
                out.println(passwordHashed);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
