/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ejerciciogestionusuarios;

import java.util.ArrayList;

/**
 *
 * @author igallego
 */
public class Login {

    private boolean logged;

    public User myLogin(String email, String password, String answer, ArrayList<User> userList) {
        for (User u : userList) {
            if (email.equals(u.getEmail()) && password.equals(u.getPassword())) {
                logged = true;
                System.out.println("Ha iniciado sesión como " + u.getName());
                return u;
            } else {
                System.out.println("Contraseña incorrecta, introduce la respuesta de seguridad a la pregunta: " + u.getQuestion());
                if (email.equals(u.getEmail()) && answer.equals(u.getAnswer())) {
                    logged = true;
                    System.out.println("Ha iniciado sesión como " + u.getName());
                    return u;
                }
            }

        }

        return null;

    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

}
