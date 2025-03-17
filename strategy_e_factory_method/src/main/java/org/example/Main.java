package org.example;// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentFactory factory = new PaymentFactoryImpl();

        System.out.println("Choose a payment method:");
        System.out.println("1. Pix");
        System.out.println("2. Cartão de Crédito");
        System.out.println("3. Boleto");
        System.out.println("Enter your choice: ");
        String choice = scanner.nextLine();

        System.out.println("Enter the transaction amount:");
        double amount = scanner.nextDouble();

        try {
            PaymentStrategy strategy = factory.createPaymentMethod(choice);
            PaymentProcessor processor = new PaymentProcessor(strategy);
            processor.process(amount);
            System.out.println("Payment processed successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}