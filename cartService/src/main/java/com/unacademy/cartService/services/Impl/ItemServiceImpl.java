package com.unacademy.cartService.services.Impl;

import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.CartNotFoundException;
import com.unacademy.cartService.exceptions.ItemNotFoundException;
import com.unacademy.cartService.services.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    @Override
    public Item createItem(Item item) {
        return null;
    }

    @Override
    public Item findByItemId(int itemId) throws ItemNotFoundException {
        return null;
    }

    @Override
    public boolean deleteItem(int itemId) throws ItemNotFoundException {
        return false;
    }

    @Override
    public List<Item> getListOfAllItems() {
        return null;
    }

    @Override
    public Item addItemToGivenCart(Item item, int cartId) throws CartNotFoundException {
        return null;
    }

    @Override
    public boolean removeItemFromGivenCart(int itemId, int cartId) throws CartNotFoundException, ItemNotFoundException {
        return false;
    }

}
