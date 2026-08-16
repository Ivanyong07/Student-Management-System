package com.store.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PayPallPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("PAYPALL");
        System.out.println("Amount: " + amount);
    }
}
