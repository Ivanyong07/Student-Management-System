package com.store.demo.order.dto;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class OrderRequest {

    @NotEmpty(message = "Item list cannot be empty")
    private List<String> item;

    @NotEmpty(message = "Payment method is requeired")
    private String paymentMethod;

    @Positive(message = "Amount must be greater than 0")
    private double amount;

    @Min(value = 1, message = "Quantity myst be at least 1")
    private int quantity;

    public List<String> getItem() {
        return item;
    }

    public void setItem(List<String> item) {
        this.item = item;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
