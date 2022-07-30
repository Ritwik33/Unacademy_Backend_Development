package com.unacademy.cartService.services;

import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.CartNotFoundForGivenIdException;
import com.unacademy.cartService.exceptions.ItemNotFoundForGivenIdException;
import com.unacademy.cartService.exceptions.ItemWithThisNameNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface ItemService {

    public Item createItem(Item item);

    public List<Item> createMultipleItems(List<Item> items);

    public Item getItemDetailsByItemId(int itemId) throws ItemNotFoundForGivenIdException;

    public Item getItemDetailsByItemName(String itemName) throws ItemWithThisNameNotFoundException;

    public List<Item> getListOfItemsOfTheSameCategory(String category);

    public List<Item> getListOfItemsManufacturedOnTheSameDate(LocalDate manufacturingDate);

    public List<Item> getListOfAllItems();

    public Item updateItem(int itemId, Item item) throws ItemNotFoundForGivenIdException;

    public boolean deleteItem(int itemId) throws ItemNotFoundForGivenIdException;

    public Cart addItemToGivenCart(Item item, int cartId) throws CartNotFoundForGivenIdException;

}
