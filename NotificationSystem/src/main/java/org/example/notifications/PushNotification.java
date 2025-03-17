package org.example.notifications;

public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando notificação push: " + message);
    }
}