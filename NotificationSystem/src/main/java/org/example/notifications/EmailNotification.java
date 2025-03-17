package org.example.notifications;

public class EmailNotification implements Notification {
    private String recipientEmail;

    public EmailNotification(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    @Override
    public void send(String message) {
        System.out.println("Enviando e-mail para " + recipientEmail + ": " + message);
    }
}