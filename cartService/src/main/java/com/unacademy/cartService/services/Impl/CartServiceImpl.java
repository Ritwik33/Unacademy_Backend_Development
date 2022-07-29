package com.unacademy.cartService.services.Impl;

import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Customer;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.CartNotFoundException;
import com.unacademy.cartService.services.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {

    @Override
    public Cart createCart(Cart cart) {
        return null;
    }

    @Override
    public Cart findByCartId(int cartId) throws CartNotFoundException {
        return null;
    }

    @Override
    public boolean deleteCart(int cartId) throws CartNotFoundException {
        return false;
    }

    @Override
    public List<Item> getListOfAllItemsInTheCart(int cartId) throws CartNotFoundException {
        return null;
    }

    @Override
    public Customer getCustomerByCartId(int cartId) throws CartNotFoundException {
        return null;
    }
}
