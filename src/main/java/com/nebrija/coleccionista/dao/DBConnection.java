package com.nebrija.coleccionista.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static final String jdbcURL = "jdbc:mysql://localhost:3306/coleccionista";
    private static Connection jdbcConnection = null;

    private DBConnection(){}

    /* public DBConnection(String jdbcURL, String jdbcUser, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUser = jdbcUser;
        this.jdbcPassword = jdbcPassword;
    } */

    //Métodos Para Conectarse y Desconectarse

    public static Connection getConnection() throws SQLException { //Patrón Singleton

        if (jdbcConnection == null || jdbcConnection.isClosed()){
            Properties props = new Properties();
            props.put("user", "root");
            props.put("password", "root");
            jdbcConnection = DriverManager.getConnection(jdbcURL, props);
        }
        return jdbcConnection;
    }

    /* public void conectarse() throws SQLException { //Este método tenía seteados la url, el user y el passwd en el web-inf xml y se le llamaba con el getParameter.
        if (jdbcConnection == null || jdbcConnection.isClosed()) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }

            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
        }
    } */

    public void desconectarse() throws SQLException {
        if (jdbcConnection !=null && !jdbcConnection.isClosed()){

            try {
                jdbcConnection.close();
            } catch (SQLException e) {
                throw new SQLException(e);
            }
        }
    }
}
