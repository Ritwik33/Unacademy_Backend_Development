package com.unacademy.cartService.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CartDTO {

    @JsonProperty(value = "cart_id")
    private int cartId;

    private CustomerDTO customer;

    private List<ItemDTO> items;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
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
