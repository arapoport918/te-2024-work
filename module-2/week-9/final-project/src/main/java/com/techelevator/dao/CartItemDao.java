package com.techelevator.dao;

import com.techelevator.model.Cart;
import com.techelevator.model.CartItem;
import com.techelevator.model.LineItem;


import java.util.List;

public interface CartItemDao {
    Cart viewCart(int id);
    int addToCart(CartItem item);
    int removeFromCart(int cartItemId);
    int clearCart(int userId);

}
