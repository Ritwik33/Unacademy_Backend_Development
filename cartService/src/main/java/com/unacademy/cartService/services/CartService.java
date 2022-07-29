package com.unacademy.cartService.services;

import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Customer;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.CartNotFoundException;

import java.util.List;

public interface CartService {

    public Cart createCart(Cart cart);

    public Cart findByCartId(int cartId) throws CartNotFoundException;

    public boolean deleteCart(int cartId) throws CartNotFoundException;

    public List<Item> getListOfAllItemsInTheCart(int cartId) throws CartNotFoundException;

    public Customer getCustomerByCartId(int cartId) throws CartNotFoundException;

}
