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
public class User {

    private String name;
    private String password;
    private String email;
    private String answer;
    private String question;
    private ArrayList<Message> messageList = new ArrayList();

    public User(String name, String password, String email, String answer) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void receiveMessage(Message message) {
        messageList.add(message);
    }

    public ArrayList<Message> showMessages() {
        int cont = 1;
        for (Message message : this.messageList) {

            System.out.println(cont + message.getMessage() );
            cont++;
        }
        return this.messageList;
    }
    
        public ArrayList<User> showUsers() {
        int cont = 1;
        for (User user : UserManagement.getUserList()) {

            System.out.println(cont + " -" + user.getName());
            cont++;
        }
        return UserManagement.getUserList();
    }

    public User chooseUser(int index) {
        return UserManagement.getUserList().get(index);
    }
}
