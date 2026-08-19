package com.store.demo.order;

import org.springframework.stereotype.Service;

@Service
public class StripePaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " payment via Stripe");
    }
}
