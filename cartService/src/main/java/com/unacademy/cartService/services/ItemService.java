package com.unacademy.cartService.services;

import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.*;

import java.time.LocalDate;
import java.util.List;

public interface ItemService {

    public Item createItem(Item item);

    public List<Item> createMultipleItems(List<Item> items);

    public Item getItemDetailsByItemId(int itemId) throws ItemNotFoundForGivenIdException;

    public Item getItemDetailsByItemName(String itemName) throws ItemWithThisNameNotFoundException;

    public List<Item> getListOfItemsOfTheSameCost(double cost) throws NoItemFoundAtThisCostException;

    public List<Item> getListOfItemsOfTheSameCategory(String category) throws NoItemFoundWithTheGivenCategoryException;

    public List<Item> getListOfItemsManufacturedOnTheSameDate(LocalDate manufacturingDate)
            throws NoItemFoundWithTheGivenManufacturingDateException;

    public List<Item> getListOfAllItems() throws NoItemFoundException;

    public Item updateItem(int itemId, Item item) throws ItemNotFoundForGivenIdException;

    public boolean deleteItem(int itemId) throws ItemNotFoundForGivenIdException;

    public Cart addItemToGivenCart(Item item, int cartId) throws CartNotFoundForGivenIdException;

    public Cart addMultipleItemsToGivenCart(List<Item> items, int cartId) throws CartNotFoundForGivenIdException;

}
