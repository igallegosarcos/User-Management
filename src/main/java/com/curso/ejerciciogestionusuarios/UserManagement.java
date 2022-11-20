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
public class UserManagement {

    private static UserManagement ddbb;
    private static ArrayList<Message> messageList;
    private static ArrayList<User> userList;
    private static ArrayList<SecurityQuestion> questionList;

    private UserManagement() {
        messageList = new ArrayList();
        userList = new ArrayList();
        questionList = new ArrayList();
    }

    public static UserManagement getInstance() {
        if (ddbb == null) {
            ddbb = new UserManagement();
        }
        return ddbb;
    }

    public static void addUser(User user) {
        userList.add(user);
    }

    public static void addMessage(Message message) {
        messageList.add(message);
    }

    public static ArrayList<Message> getMessageList() {
        return messageList;
    }

    public static void setMessageList(ArrayList<Message> messageList) {
        UserManagement.messageList = messageList;
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public static void setUserList(ArrayList<User> userList) {
        UserManagement.userList = userList;
    }

    public static ArrayList<SecurityQuestion> getQuestionList() {
        return questionList;
    }

    public static void setQuestionList(ArrayList<SecurityQuestion> questionList) {
        UserManagement.questionList = questionList;
    }

}
