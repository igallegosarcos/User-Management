/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.curso.ejerciciogestionusuarios;

import java.util.Scanner;

/**
 *
 * @author igallego
 */
public class EjercicioGestionUsuarios {

    static Scanner sc = new Scanner(System.in);
    static String dataName;
    static String dataEmail;
    static String dataPassword;
    static UserManagement ddbb = UserManagement.getInstance();
    static Login log;
    static User uLogged;
    static int option;
    static boolean session;
    static int opMain;
    static String dataQuestion;
    static String dataAnswer;
    static Message dataMessage;

    public static void main(String[] args) {

        do {
            System.out.println("Bienvenido. \n Si quiere iniciar sesión, escriba 1. Si quiere registrarse, escriba 2.");
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir el número 1 o el 2");
            }
            switch (option) {
                case 1:
                    session = login();
                    while (session) {
                        System.out.println("¿Qué quiere hacer? \n 1- Establecer pregunta de seguridad \n 2- Modificar email \n 3- Modificar contraseña \n 4- Enviar un mensaje a otro usuario \n 5- Ver la bandeja de entrada \n 6- Cerrar sesión");
                        try {
                            opMain = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Debes introducir un número entre 1 y 5");
                        }
                        switch (opMain) {
                            case 1:
                                securityQuestion();
                                securityAnswer();
                                break;
                            case 2:
                                changeEmail();
                                break;
                            case 3:
                                changePassword();
                                break;
                            case 4:
                                sendMessage();
                                break;
                            case 5:
                                uLogged.showMessages();
                                break;
                            case 6:
                                logOut();
                                break;
                            default:
                                System.out.println("Introduce una opción válida.");

                        }
                    }
                    break;
                case 2:
                    register();
                    System.out.println("¡Te has registrado!");
                    break;
                default:
                    System.out.println("Introduce una opción válida.");
            }

        } while (true);

    }

    public static boolean login() {
        System.out.println("Introduce el email");
        dataEmail = sc.nextLine();
        System.out.println("Introduce la contraseña");
        dataPassword = sc.nextLine();
        log = new Login();
        uLogged = log.myLogin(dataEmail, dataPassword, "", UserManagement.getUserList());
        if (uLogged == null) {
            dataAnswer = sc.nextLine();
            log = new Login();
            uLogged = log.myLogin(dataEmail, "", dataAnswer, UserManagement.getUserList());
            return log.isLogged();
        }
        return log.isLogged();
    }

    public static void register() {
        System.out.println("Hola, ha elegido registrarse. ¿Cómo se llama?");
        dataName = sc.nextLine();
        System.out.println("Introduce el email");
        dataEmail = sc.nextLine();
        System.out.println("Introduce la contraseña");
        dataPassword = sc.nextLine();
        Register r = new Register();
        r.setRegister(dataName, dataPassword, dataEmail, "", UserManagement.getUserList());

    }

    public static String securityQuestion() {
        System.out.println("¿Cuál es la pregunta de seguridad?");
        dataQuestion = sc.nextLine();
        uLogged.setQuestion(dataQuestion);
        System.out.println("Pregunta de seguridad establecida.");
        return dataQuestion;
    }

    public static void securityAnswer() {
        System.out.println("¿Cuál es la respuesta?");
        dataAnswer = sc.nextLine();
        uLogged.setAnswer(dataAnswer);
        System.out.println("Pregunta de seguridad establecida.");
    }

    public static void changeEmail() {
        System.out.println("Escriba el nuevo email");
        dataEmail = sc.nextLine();
        uLogged.setEmail(dataEmail);
        System.out.println("Ahora tu email es: " + uLogged.getEmail());
    }

    public static void changePassword() {
        System.out.println("Escriba la nueva contraseña");
        dataPassword = sc.nextLine();
        uLogged.setPassword(dataPassword);
        System.out.println("Ahora tu contraseña es: " + uLogged.getPassword());
    }

    public static void logOut() {
        session = false;
    }

    public static void sendMessage() {
        System.out.println("Elige a quien le quieres enviar un mensaje");
        uLogged.showUsers();
        int indexRecipient = 0;
        try {
            indexRecipient = Integer.parseInt(sc.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Introduce un número válido");
        }
        User choseRecipient = uLogged.chooseUser(indexRecipient);
        System.out.println("Escribe el mensaje que quieres enviar");
        String message=sc.nextLine();
        dataMessage.setMessage(message);
        choseRecipient.receiveMessage(dataMessage);

    }

}
