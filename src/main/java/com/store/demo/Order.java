package com.store.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String paymentMethod;

    @ElementCollection
    private List<String> item;

    private int quantity;

    public Order() {
    }

    public Order(double amount, String paymentMethod, int quantity, List<String> item) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.quantity = quantity;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<String> getItem() {
        return item;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItem(List<String> item) {
        this.item = item;
    }
}
