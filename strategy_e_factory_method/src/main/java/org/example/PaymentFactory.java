package org.example;

// PaymentFactory.java
public interface PaymentFactory {
    PaymentStrategy createPaymentMethod(String type);
}