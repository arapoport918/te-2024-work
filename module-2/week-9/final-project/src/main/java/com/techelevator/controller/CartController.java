package com.techelevator.controller;

import com.techelevator.dao.CartItemDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Cart;
import com.techelevator.model.CartItem;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;


@RestController
@PreAuthorize("isAuthenticated()")
public class CartController {
    private final CartItemDao cartItemDao;
    private final UserDao userDao;

    public CartController(CartItemDao dao, UserDao user) {
        this.cartItemDao = dao;
        this.userDao = user;
    }

    @RequestMapping(path = "/cart", method = RequestMethod.GET)
    public Cart list(Principal principal) {
        int userId = userDao.getUserByUsername(principal.getName()).getId();
        return cartItemDao.viewCart(userId);
    }

    @RequestMapping(path = "/cart/items", method = RequestMethod.POST)
    public int add (@RequestBody CartItem cartItem) {
        return cartItemDao.addToCart(cartItem);
    }

    @RequestMapping(path = "/cart/items/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable int id) {
        return cartItemDao.removeFromCart(id);
    }

    @RequestMapping(path = "/cart", method = RequestMethod.DELETE)
    public int clear(Principal principal) {
        return cartItemDao.clearCart(getUserInfo(principal).getId());
    }

    private User getUserInfo(Principal principal) {
        String username = principal.getName();
        return userDao.getUserByUsername(username);
    }

}
