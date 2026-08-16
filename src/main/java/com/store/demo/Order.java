package com.store.demo;

import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String paymentMethod;
    private ArrayList<String> item;
    private int quantity;

    public Order() {
    }

    public Order(double amount, String paymentMethod, int quantity, ArrayList<String> item) {
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

    public ArrayList<String> item() {
        return item;
    }
}
