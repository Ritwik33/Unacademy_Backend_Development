package com.unacademy.cartService.dtos;

import com.unacademy.cartService.entities.Customer;
import com.unacademy.cartService.entities.Item;

import java.util.List;

public class CartDTO {

    private int cartId;

    private Customer customer;

    private List<Item> items;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "cartId=" + cartId +
                ", customer=" + customer +
                ", items=" + items +
                '}';
    }
}
