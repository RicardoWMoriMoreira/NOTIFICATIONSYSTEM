package org.example;

// CreditCardPayment.java
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of R$" + amount);
    }
}
