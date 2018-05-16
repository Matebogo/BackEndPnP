/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.service;

import com.web.pnp.model.Cart;
import com.web.pnp.model.CartItem;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Reverside
 */
@Service
public class CartIService {

    private final Cart cart = new Cart();

    public void addToCart(CartItem cartItem) {

        cart.addToCart(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {

        cart.removeCartItem(cartItem);
    }

    public double getTotalPrice() {

        return cart.getTotalPrice();
    }

    public int getCartSize() {

        return cart.getSize();
    }

    public List<CartItem> getCartItems() {

        return cart.getCartItems();
    }

    public void removeAll() {

        cart.removeAll();
    }

}
