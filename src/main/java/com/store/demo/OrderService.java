package com.store.demo;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final PaymentService paymentService;
    private final OrderRepository orderRepository;

    public OrderService(PaymentService paymentService, OrderRepository orderRepository) {
        this.paymentService = paymentService;
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(OrderRequest request) {
        paymentService.processPayment(request.getAmount());

        Order order = new Order(
                request.getAmount(),
                request.getPaymentMethod(),
                request.getQuantity(),
                request.getItem());

        return orderRepository.save(order);
    }

    public void cancelOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with id: " + id);
        }

        orderRepository.deleteById(id);
    }

    public Order updateOrder(Long id, OrderRequest request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not dound with id: " + id));

        order.setAmount(request.getAmount());
        order.setPaymentMethod(request.getPaymentMethod());
        order.setQuantity(request.getQuantity());
        order.setItem(request.getItem());

        return orderRepository.save(order);
    }
}