package org.example.notifications;

public class SMSNotification implements Notification {
    private String recipientNumber;

    public SMSNotification(String recipientNumber) {
        this.recipientNumber = recipientNumber;
    }

    @Override
    public void send(String message) {
        System.out.println("Enviando SMS para " + recipientNumber + ": " + message);
    }
}