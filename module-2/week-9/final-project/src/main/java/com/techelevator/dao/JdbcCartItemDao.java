package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Cart;
import com.techelevator.model.CartItem;
import com.techelevator.model.LineItem;
import com.techelevator.model.User;
import com.techelevator.service.RestTaxRateService;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
@PreAuthorize("isAuthenticated()")
public class JdbcCartItemDao implements CartItemDao {
    private JdbcTemplate jdbcTemplate;
    private final String SQL_BASE = "SELECT cart_item_id, user_id, product_id, quantity " +
            "FROM cart_item ";

    public JdbcCartItemDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private List<LineItem> getLineItemsByUserId(int id) {
        String sql = "SELECT p.name, p.price, ci.quantity " +
                "FROM cart_item ci " +
                "JOIN product p ON p.product_id = ci.product_id " +
                "WHERE ci.user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        return listLineItems(results);
    }

    @Override
    public Cart viewCart(int userId) {
        Cart cart = new Cart();
        cart.setUserId(userId);

        List<LineItem> lineItemsList = getLineItemsByUserId(userId);

        cart.setLineItems(lineItemsList);
        cart.setSubtotal(getCartSubtotal(userId));
        cart.setTax(getTaxRate(userId));
        cart.setTotal(getCartSubtotal(userId) + (getTaxRate(userId)));

        return cart;
    }

    @Override
    public int addToCart(CartItem itemToBeAdded) {
        String sqlCompare = "SELECT cart_item_id, product_id, user_id, quantity " +
                "FROM cart_item " +
                "WHERE user_id = ? AND product_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCompare,
                itemToBeAdded.getUserId(),
                itemToBeAdded.getProductId());

        if (!results.next()) {
            String sqlAdd = "INSERT INTO cart_item (user_id, product_id, quantity) " +
                    "VALUES (?, ?, ?) RETURNING cart_item_id;";
            return jdbcTemplate.update(sqlAdd,
                    itemToBeAdded.getUserId(),
                    itemToBeAdded.getProductId(),
                    itemToBeAdded.getQuantity());

        } else {
            CartItem compare = map(results);
            String sqlUpdate = "UPDATE cart_item SET quantity = ? WHERE user_id = ?;";
            return jdbcTemplate.update(sqlUpdate,
                    compare.getQuantity() + itemToBeAdded.getQuantity(),
                    compare.getUserId());
        }

    }

    @Override
    public int removeFromCart(int cartItemId) {
        String sql = "DELETE FROM cart_item WHERE cart_item_id = ? ;";
        return jdbcTemplate.update(sql, cartItemId);
    }

    @Override
    public int clearCart(int userId) {
        String sql = "DELETE FROM cart_item WHERE user_id = ?";
        return jdbcTemplate.update(sql, userId);
    }

    private CartItem map(SqlRowSet results) {
        CartItem cartItem = new CartItem();

        cartItem.setCartItemId(results.getInt("cart_item_id"));
        cartItem.setUserId(results.getInt("user_id"));
        cartItem.setProductId(results.getInt("product_id"));
        cartItem.setQuantity(results.getInt("quantity"));

        return cartItem;
    }

    private LineItem mapReceipt(SqlRowSet results) {
       LineItem lineItem = new LineItem();

       lineItem.setName(results.getString("name"));
       lineItem.setQuantity(results.getInt("quantity"));
       lineItem.setPrice(results.getBigDecimal("price").setScale(2, RoundingMode.HALF_UP));

       return lineItem;
    }

    private List<CartItem> listCartItems(SqlRowSet results) {
        List<CartItem> items = new ArrayList<>();

        while(results.next()) {
            items.add(map(results));
        }

        return items;
    }

    private List<LineItem> listLineItems(SqlRowSet results) {
        List<LineItem> items = new ArrayList<>();

        while(results.next()) {
            items.add(mapReceipt(results));
        }

        return items;
    }

    private double getCartSubtotal(User user) {
        String sql = "SELECT SUM(p.price * ci.quantity) FROM product p " +
                "JOIN cart_item ci ON p.product_id = ci.product_id " +
                "WHERE ci.user_id = ?;";
        try {
            return jdbcTemplate.queryForObject(sql, double.class, user.getId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database.", e);
        }
    }

    private double getTaxRate(User user) {
        RestTaxRateService tax = new RestTaxRateService();
        String sql = "SELECT state_code " +
                "FROM users  " +
                "WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user.getId());

        if (results.next()) {
            double rate = tax.getTaxRate(results.getString("state_code"));
            double value = getCartSubtotal(user) * (rate / 100);
            return value;
        }

        return 0;
    }

}
