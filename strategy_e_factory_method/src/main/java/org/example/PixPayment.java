package org.example;

// PixPayment.java
public class PixPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Pix payment of R$" + amount);
    }
}