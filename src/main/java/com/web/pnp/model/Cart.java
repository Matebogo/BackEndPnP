 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {

    private List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getSize() {

        return this.cartItems.size();
    }

    public void addToCart(CartItem cartItem) {

        if (this.getCartItems().isEmpty()) {

            this.getCartItems().add(cartItem);

        } else if (!this.getCartItems().isEmpty()) {

            for (int i = 0; i < this.getSize(); i++) {

                if (this.getCartItems().get(i).getProduct().getProductName().
                        equalsIgnoreCase(cartItem.getProduct().getProductName())) {

                    this.getCartItems().remove(this.getCartItems().get(i));
                }
            }
            this.getCartItems().add(cartItem);
        }

    }

    public void removeCartItem(CartItem cartItem) {

        for (int i = 0; i < this.getSize(); i++) {

            if (this.getCartItems().get(i).getProduct().getProductName()
                    .equalsIgnoreCase(cartItem.getProduct().getProductName())) {

                if (this.getCartItems().get(i).getCount()== 1) {

                    this.getCartItems().remove(this.getCartItems().get(i));

                } else if (this.getCartItems().get(i).getCount()> 1) {

                    this.getCartItems().get(i).setCount(this.getCartItems().get(i).getCount()- 1);
                }
            }
        }
    }

    public void removeAll() {

        this.getCartItems().removeAll(this.getCartItems());
    }

    public double getTotalPrice(){
    
        double total = 0;
        
        for (int i = 0; i < this.getSize(); i++) {
            
            total += this.getCartItems().get(i).getProduct().getPrice()
                    * this.getCartItems().get(i).getCount();
           
        }
        
        return total;
    }
}
