package org.example.notifications;

public class NotificationFactory {
    public static Notification createNotification(String type, String recipient) {
        switch (type) {
            case "EMAIL":
                return new EmailNotification(recipient);
            case "SMS":
                return new SMSNotification(recipient);
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Tipo de notificação não suportado.");
        }
    }
}