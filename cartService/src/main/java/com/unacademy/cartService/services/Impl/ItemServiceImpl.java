package com.unacademy.cartService.services.Impl;

import com.unacademy.cartService.daos.CartDao;
import com.unacademy.cartService.daos.ItemDao;
import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.*;
import com.unacademy.cartService.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private CartServiceImpl cartService;

    @Override
    public Item createItem(Item item) {
        return itemDao.save(item);
    }

    @Override
    public List<Item> createMultipleItems(List<Item> items) {
        List<Item> savedItems = new ArrayList<>();
        items.forEach(item -> savedItems.add(itemDao.save(item)));
        return savedItems;
    }

    @Override
    public Item getItemDetailsByItemId(int itemId) throws ItemNotFoundForGivenIdException {
        return itemDao.findById(itemId).orElseThrow(() ->
                new ItemNotFoundForGivenIdException("Item not found for the id: " + itemId));
    }

    @Override
    public Item getItemDetailsByItemName(String itemName) throws ItemWithThisNameNotFoundException {
        Item searchedItem = itemDao.findByItemName(itemName);
        if(searchedItem == null) {
            throw new ItemWithThisNameNotFoundException("Item not found by the name: " + itemName);
        }
        return searchedItem;
    }

    @Override
    public List<Item> getListOfItemsOfTheSameCategory(String category) throws
            NoItemFoundWithTheGivenCategoryException {

        List<Item> foundItems = itemDao.findByCategory(category);

        if(foundItems.isEmpty()) {
            throw new NoItemFoundWithTheGivenCategoryException("No item found with the category: " + category);
        }

        return foundItems;

    }

    @Override
    public List<Item> getListOfItemsManufacturedOnTheSameDate(LocalDate manufacturingDate) throws
            NoItemFoundWithTheGivenManufacturingDateException {

        List<Item> foundItems = itemDao.findByManufacturingDate(manufacturingDate);

        if(foundItems.isEmpty()) {
            throw new NoItemFoundWithTheGivenManufacturingDateException(
                    "No item found with the manufacturing Date: " + manufacturingDate);
        }

        return foundItems;

    }

    @Override
    public List<Item> getListOfItemsOfTheSameCost(double cost) throws NoItemFoundAtThisCostException {

        List<Item> foundItems = itemDao.findByCost(cost);
        if(foundItems.isEmpty()) {
            throw new NoItemFoundAtThisCostException("No item found at cost: " + cost);
        }
        return foundItems;
    }

    @Override
    public List<Item> getListOfAllItems() throws NoItemExistsException {

        List<Item> foundItems = itemDao.findAll();

        if(foundItems.isEmpty()) {
            throw new NoItemExistsException("no item found");
        }

        return foundItems;

    }

    @Override
    public Item updateItem(int itemId, Item item) throws ItemNotFoundForGivenIdException {

        Item searchedItem = getItemDetailsByItemId(itemId);

        if(isNotNullOrZero(item.getItemName())) {
            searchedItem.setItemName(item.getItemName());
        }
        if(isNotNullOrZero(item.getItemDescription())) {
            searchedItem.setItemDescription(item.getItemDescription());
        }
        if(isNotNullOrZero(item.getCategory())) {
            searchedItem.setCategory(item.getCategory());
        }
        if(isNotNullOrZero(item.getCost())) {
            searchedItem.setCost(item.getCost());
        }
        if(isNotNullOrZero(item.getManufacturingDate())) {
            searchedItem.setManufacturingDate(item.getManufacturingDate());
        }

        return itemDao.save(searchedItem);

    }

    @Override
    public boolean deleteItem(int itemId) throws ItemNotFoundForGivenIdException {

        Item searchedItem = getItemDetailsByItemId(itemId);

        itemDao.delete(searchedItem);
        return true;

    }

    @Override
    public Cart addItemToGivenCart(int itemId, int cartId)
            throws ItemNotFoundForGivenIdException,
            CartNotFoundForGivenIdException {

        Cart foundCart = cartService.getCartDetailsByCartId(cartId);
        Item foundItem = itemDao.findById(itemId).orElseThrow(() ->
                new ItemNotFoundForGivenIdException("Item not found for id: " + itemId));
        foundCart.getItems().add(foundItem);
        return cartDao.save(foundCart);

    }

    @Override
    public Cart addMultipleItemsToGivenCart(List<Integer> itemIds, int cartId) throws CartNotFoundForGivenIdException {

        List<Item> foundItems = new ArrayList<>();
        itemIds.forEach(itemId -> {
            try {
                foundItems.add(itemDao.findById(itemId).orElseThrow(() ->
                        new ItemNotFoundForGivenIdException("item not found for id: " + itemId)));
            } catch (ItemNotFoundForGivenIdException e) {
                throw new RuntimeException(e);
            }
        });
        Cart foundCart = cartService.getCartDetailsByCartId(cartId);
        foundItems.forEach(item -> foundCart.getItems().add(item));
        return cartDao.save(foundCart);

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
