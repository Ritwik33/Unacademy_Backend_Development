package com.unacademy.cartService.services;

import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Customer;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.*;

import java.util.List;

public interface CartService {

    public Cart createCart(Cart cart);

    public List<Cart> createMultipleCarts(List<Cart> carts);

    public Cart getCartDetailsByCartId(int cartId) throws CartNotFoundException;

    public Cart getCartDetailsByCustomer(Customer customer) throws
            CartNotFoundException;

    public List<Item> getListOfAllItemsInTheCart(int cartId) throws CartNotFoundException;

    public Cart updateCart(int cartId, Cart cart) throws CartNotFoundException;

    public boolean deleteCart(int cartId) throws CartNotFoundException;

    public Customer getCustomerByCartId(int cartId) throws CartNotFoundException;

    public boolean removeItemFromGivenCart(int cartId, int itemId) throws CartNotFoundException,
            ItemNotFoundException,
            ItemNotFoundInGivenCartException;

}
