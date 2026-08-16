package com.store.demo;

import java.util.ArrayList;

public class OrderRequest {

    private ArrayList<String> item;
    private String paymentMethod;
    private double amount;
    private int quantity;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
