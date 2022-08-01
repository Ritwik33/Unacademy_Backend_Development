package com.unacademy.cartService.services.Impl;

import com.unacademy.cartService.daos.CartDao;
import com.unacademy.cartService.daos.ItemDao;
import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Customer;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.*;
import com.unacademy.cartService.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ItemDao itemDao;

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
    public Cart getCartDetailsByCustomer(Customer customer) throws NoCartFoundForGivenCustomerException {
        Cart searchedCart = cartDao.findByCustomer(customer);
        if(searchedCart == null) {
            throw new NoCartFoundForGivenCustomerException("no cart found for the given customer: " + customer);
        }
        return searchedCart;
    }

    @Override
    public List<Item> getListOfAllItemsInTheCart(int cartId) throws CartNotFoundForGivenIdException {
        Cart searchedCart = getCartDetailsByCartId(cartId);
        return searchedCart.getItems();
    }

    @Override
    public Customer getCustomerByCartId(int cartId) throws CartNotFoundForGivenIdException {
        Cart searchedCart = getCartDetailsByCartId(cartId);
        return searchedCart.getCustomer();
    }

    @Override
    public List<Cart> getAllCarts() throws NoCartExistsException {

        List<Cart> foundCarts = cartDao.findAll();

        if(foundCarts.isEmpty()) {
            throw new NoCartExistsException("No Cart Exists as of now");
        }

        return foundCarts;

    }

    @Override
    public Cart updateCart(int cartId, Cart cart) throws CartNotFoundForGivenIdException {
        Cart searchedCart = getCartDetailsByCartId(cartId);
        if(isNotNullOrZero(cart.getCustomer())) {
            searchedCart.setCustomer(cart.getCustomer());
        }
        if(isNotNullOrZero(cart.getItems())) {
            searchedCart.setItems(cart.getItems());
        }
        return cartDao.save(searchedCart);
    }

    @Override
    public boolean deleteCart(int cartId) throws CartNotFoundForGivenIdException {
        Cart searchedCart = getCartDetailsByCartId(cartId);
        cartDao.delete(searchedCart);
        return true;
    }

    @Override
    public Cart removeItemFromGivenCart(int cartId, int itemId) throws
            CartNotFoundForGivenIdException,
            ItemNotFoundForGivenIdException,
            ItemNotFoundInGivenCartException {

        Cart foundCart = getCartDetailsByCartId(cartId);
        Item foundItem = itemDao.findById(itemId).orElseThrow(() ->
                new ItemNotFoundForGivenIdException("Item not found with id: " + itemId));

        if(foundCart.getItems().contains(foundItem)) {
            foundCart.getItems().remove(foundItem);
            return cartDao.save(foundCart);
        }

        throw new ItemNotFoundInGivenCartException("Given item not found in the given cart");

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
