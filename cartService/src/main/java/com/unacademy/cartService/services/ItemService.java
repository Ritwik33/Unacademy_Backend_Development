package com.unacademy.cartService.services;

import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.CartNotFoundException;
import com.unacademy.cartService.exceptions.ItemNotFoundException;

import java.util.List;

public interface ItemService {

    public Item createItem(Item item);

    public Item findByItemId(int itemId) throws ItemNotFoundException;

    public boolean deleteItem(int itemId) throws ItemNotFoundException;

    public List<Item> getListOfAllItems();

    public Item addItemToGivenCart(Item item, int cartId) throws CartNotFoundException;

    public boolean removeItemFromGivenCart(int itemId, int cartId) throws CartNotFoundException, ItemNotFoundException;

}
