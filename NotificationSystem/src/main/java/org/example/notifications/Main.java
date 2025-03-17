package org.example.notifications;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha o tipo de notificação:");
            System.out.println("1: Email");
            System.out.println("2: SMS");
            System.out.println("3: Push Notification");
            System.out.println("4: Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (choice == 4) {
                System.out.println("Saindo...");
                break;
            }

            String recipient = "";
            if (choice == 1) {
                System.out.println("Digite o e-mail do destinatário:");
                recipient = scanner.nextLine();
            } else if (choice == 2) {
                System.out.println("Digite o número do destinatário:");
                recipient = scanner.nextLine();
            }

            System.out.println("Digite a mensagem a ser enviada:");
            String message = scanner.nextLine();

            try {
                Notification notification = null;
                switch (choice) {
                    case 1:
                        notification = NotificationFactory.createNotification("EMAIL", recipient);
                        break;
                    case 2:
                        notification = NotificationFactory.createNotification("SMS", recipient);
                        break;
                    case 3:
                        notification = NotificationFactory.createNotification("PUSH", null);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        continue;
                }

                // Enviar a mensagem
                notification.send(message);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}