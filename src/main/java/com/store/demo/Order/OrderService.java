package com.store.demo.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.demo.order.dto.OrderRequest;
import com.store.demo.order.dto.OrderResponse;

@Service
public class OrderService {
    private final PaymentService paymentService;
    private final OrderRepository orderRepository;

    public OrderService(PaymentService paymentService, OrderRepository orderRepository) {
        this.paymentService = paymentService;
        this.orderRepository = orderRepository;
    }

    public OrderResponse placeOrder(OrderRequest request) {
        paymentService.processPayment(request.getAmount());

        Order order = new Order(
                request.getAmount(),
                request.getPaymentMethod(),
                request.getQuantity(),
                request.getItem());

        Order savedOrder = orderRepository.save(order);

        OrderResponse response = new OrderResponse();

        response.setOrderId(savedOrder.getId());
        response.setItem(savedOrder.getItem());
        response.setPaymentMethod(savedOrder.getPaymentMethod());
        response.setAmount(savedOrder.getAmount());
        response.setQuantity(savedOrder.getQuantity());

        return response;
    }

    public void cancelOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with id: " + id);
        }

        orderRepository.deleteById(id);
    }

    public OrderResponse updateOrder(Long id, OrderRequest request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));

        order.setAmount(request.getAmount());
        order.setPaymentMethod(request.getPaymentMethod());
        order.setQuantity(request.getQuantity());
        order.setItem(request.getItem());

        Order savedOrder = orderRepository.save(order);

        OrderResponse response = new OrderResponse();

        response.setOrderId(savedOrder.getId());
        response.setItem(savedOrder.getItem());
        response.setPaymentMethod(savedOrder.getPaymentMethod());
        response.setAmount(savedOrder.getAmount());
        response.setQuantity(savedOrder.getQuantity());

        return response;
    }

    public OrderResponse getOrder(Long id) {

        // Get Order from database
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Create empty response
        OrderResponse response = new OrderResponse();

        // Copy Order → Response
        response.setOrderId(order.getId());
        response.setItem(order.getItem());
        response.setPaymentMethod(order.getPaymentMethod());
        response.setAmount(order.getAmount());
        response.setQuantity(order.getQuantity());

        return response;
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository
                .findAll()
                .stream()
                .map(order -> {
                    OrderResponse response = new OrderResponse();

                    response.setOrderId(order.getId());
                    response.setItem(order.getItem());
                    response.setPaymentMethod(order.getPaymentMethod());
                    response.setAmount(order.getAmount());
                    response.setQuantity(order.getQuantity());

                    return response;
                }).toList();
    }
}