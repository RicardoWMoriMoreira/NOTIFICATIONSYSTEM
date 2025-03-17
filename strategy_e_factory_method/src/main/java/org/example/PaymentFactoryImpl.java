package org.example;

// PaymentFactoryImpl.java
public class PaymentFactoryImpl implements PaymentFactory {
    @Override
    public PaymentStrategy createPaymentMethod(String type) {
        switch (type) {
            case "1":
                return new PixPayment();
            case "2":
                return new CreditCardPayment();
            case "3":
                return new BoletoPayment();
            default:
                throw new IllegalArgumentException("Invalid payment method");
        }
    }
}