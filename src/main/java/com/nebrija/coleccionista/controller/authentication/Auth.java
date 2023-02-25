package com.nebrija.coleccionista.controller.authentication;

public interface Auth {
    boolean login(String username, String password);
    boolean logout();
    boolean register(String username, String password);
    boolean delete(String username, String password);
}
