package org.example;

// BoletoPayment.java
public class BoletoPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Boleto payment of R$" + amount);
    }
}