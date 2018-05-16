/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.controller;

import com.web.pnp.model.CartItem;
import com.web.pnp.service.CartIService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Reverside
 */
@RestController
@RequestMapping("/cart")
public class CartItemController {

    @Autowired
    private CartIService cartService;

    @RequestMapping(value = "/add-item", method = RequestMethod.POST)
    public void addToCart(@RequestBody CartItem cartItem) {

        cartService.addToCart(cartItem);
    }

    @RequestMapping(value = "/remove-item", method = RequestMethod.PUT)
    public void removeCartItem(@RequestBody CartItem cartItem) {

        cartService.removeCartItem(cartItem);
    }

    @RequestMapping(value = "/cart-size", method = RequestMethod.GET)
    public int getCartSize() {

        return cartService.getCartSize();
    }

    @RequestMapping(value = "/cart-items", method = RequestMethod.GET)
    public List<CartItem> getCartItems() {

        return cartService.getCartItems();
    }

    @RequestMapping(value = "/total", method = RequestMethod.GET)
    public double getTotalPrice() {

        return cartService.getTotalPrice();
    }

    @RequestMapping(value = "/remove-all-items", method = RequestMethod.DELETE)
    public void removeAllItems() {

        cartService.removeAll();
    }
}
