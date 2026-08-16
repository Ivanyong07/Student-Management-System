package com.store.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final PaymentService paymentService;
    private final OrderRepository orderRepository;

    public OrderService(PaymentService paymentService, OrderRepository orderRepository) {
        this.paymentService = paymentService;
        this.orderRepository = orderRepository;
    }

    public void placeOrder(OrderRequest request) {
        double amount = request.getQuantity() * 10;
        ArrayList<String> item = request.getItem();
        String paymentMethod = request.getPaymentMethod();
        paymentService.processPayment(amount);

        Order order = new Order(request.getAmount(), request.getPaymentMethod(), request.getQuantity(), item);
        return orderRepository.save(order);
    }

    public void cancelOrder() {
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }
}