package com.unacademy.cartService.services.Impl;

import com.unacademy.cartService.daos.CartDao;
import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Customer;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.CartNotFoundForGivenIdException;
import com.unacademy.cartService.exceptions.CartNotFoundForGivenCustomerException;
import com.unacademy.cartService.exceptions.ItemNotFoundException;
import com.unacademy.cartService.exceptions.ItemNotFoundInGivenCartException;
import com.unacademy.cartService.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart createCart(Cart cart) {
        return cartDao.save(cart);
    }

    @Override
    public List<Cart> createMultipleCarts(List<Cart> carts) {
        List<Cart> savedCarts = new ArrayList<>();
        carts.forEach(cart -> savedCarts.add(cartDao.save(cart)));
        return savedCarts;
    }

    @Override
    public Cart getCartDetailsByCartId(int cartId) throws CartNotFoundForGivenIdException {
        return cartDao.findById(cartId).orElseThrow(() ->
                new CartNotFoundForGivenIdException("Cart not found for id: " + cartId));
    }

    @Override
    public Cart getCartDetailsByCustomer(Customer customer) throws CartNotFoundForGivenCustomerException {
        Cart searchedCart = cartDao.findByCustomer(customer);
        if(searchedCart == null) {
            throw new CartNotFoundForGivenCustomerException("Cart not found for the given customer: " + customer);
        }
        return searchedCart;
    }

    @Override
    public List<Item> getListOfAllItemsInTheCart(int cartId) throws CartNotFoundForGivenIdException {
        Cart searchedCart = getCartDetailsByCartId(cartId);
        return searchedCart.getItems();
    }

    @Override
    public Cart updateCart(int cartId, Cart cart) throws CartNotFoundForGivenIdException {
        Cart searchedCart = getCartDetailsByCartId(cartId);
    }

    @Override
    public boolean deleteCart(int cartId) throws CartNotFoundForGivenIdException {
        return false;
    }

    @Override
    public Customer getCustomerByCartId(int cartId) throws CartNotFoundForGivenIdException {
        return null;
    }

    @Override
    public boolean removeItemFromGivenCart(int cartId, int itemId) throws CartNotFoundForGivenIdException, ItemNotFoundException, ItemNotFoundInGivenCartException {
        return false;
    }

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }

    private boolean isNotNullOrZero(int val) {
        return val != 0;
    }

    private boolean isNotNullOrZero(double val) {
        return val > 0.00;
    }
}
