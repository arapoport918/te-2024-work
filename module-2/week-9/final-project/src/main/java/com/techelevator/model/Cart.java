package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int userId;
    private List<LineItem> lineItems = new ArrayList<>();
    private double subtotal;
    private double tax;
    private double total;

    public Cart(int userId, List<LineItem> cart, double subtotal, double tax, double total) {
        this.userId = userId;
        this.lineItems = cart;
        this.subtotal = subtotal;
        this.tax = tax;
        this.total = total;
    }

    public Cart(int userId, List<LineItem> cartItems) {
        this.userId = userId;
        this.lineItems = cartItems;
    }

    public Cart() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "userId=" + userId +
                ", lineItems=" + lineItems +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", total=" + total +
                '}';
    }
}
