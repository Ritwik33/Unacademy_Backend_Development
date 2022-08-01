package com.unacademy.cartService.services;

import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Customer;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.*;

import java.util.List;

public interface CartService {

    public Cart createCart(Cart cart);

    public List<Cart> createMultipleCarts(List<Cart> carts);

    public Cart getCartDetailsByCartId(int cartId) throws CartNotFoundForGivenIdException;

    public Cart getCartDetailsByCustomer(Customer customer) throws
            NoCartFoundForGivenCustomerException;

    public List<Item> getListOfAllItemsInTheCart(int cartId) throws CartNotFoundForGivenIdException;

    public List<Cart> getAllCarts() throws NoCartExistsException;

    public Cart updateCart(int cartId, Cart cart) throws CartNotFoundForGivenIdException;

    public boolean deleteCart(int cartId) throws CartNotFoundForGivenIdException;

    public Customer getCustomerByCartId(int cartId) throws CartNotFoundForGivenIdException;

    public Cart removeItemFromGivenCart(int cartId, int itemId) throws
            CartNotFoundForGivenIdException,
            ItemNotFoundForGivenIdException,
            ItemNotFoundInGivenCartException;

}
