package com.techelevator.model;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class CartItem {
    private int cartItemId;
    private int userId;
    private int productId;
    @Min(0)
    private int quantity;

    public CartItem(int id, int user_id, int product_id, int quantity) {
        this.cartItemId = id;
        this.userId = user_id;
        this.productId = product_id;
        this.quantity = quantity;
    }

    public CartItem() {
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "car_item_id=" + cartItemId +
                ", user_id=" + userId +
                ", product_id=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
