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
public class Register {
     //Este método añade usuarios a la base de datos UserManagement
    
    public void setRegister(String name, String password, String email, String answer, ArrayList<User> userList){
        User user = new User(name,password,email,answer);
        userList.add(user);
       
    }
}
