package com.techelevator.dao;

import com.techelevator.model.Cart;
import com.techelevator.model.CartItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class JdbcCartItemDaoTests extends BaseDaoTests {

    private static final CartItem CART_ITEM_1 = new CartItem(1, 1, 1, 3);
    private static final CartItem CART_ITEM_2 = new CartItem(2, 1, 2, 1);
    private static final CartItem CART_ITEM_3 = new CartItem(3, 1, 4, 1);
    private static final CartItem CART_ITEM_4 = new CartItem(4, 2, 2, 2);
    private static final CartItem CART_ITEM_5 = new CartItem(5, 3, 1, 1);
    private static final CartItem CART_ITEM_6 = new CartItem(6, 3, 3, 5);
    private JdbcProductDaoTests dao;

    @Test
    public void viewCart_returns_list_of_items_subtotal_tax_and_total() {

    }

    @Test
    public void addToCart_returns_cart_with_newly_added_cartItem() {

    }

    @Test
    public void addToCart_returns_cart_with_newly_added_cartItem_and_updates_quantity_when_same_product_is_added() {

    }

    @Test
    public void removeFromCart_removes_selected_item_from_user_cart() {

    }

    @Test
    public void clearCart_clear_entire_cart_for_a_user() {

    }

}
