package com.unacademy.cartService.controllers;

import com.unacademy.cartService.dtos.CartDTO;
import com.unacademy.cartService.dtos.ItemDTO;
import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.*;
import com.unacademy.cartService.services.Impl.ItemServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/items")
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO) {

        Item item = convertItemDTOToItem(itemDTO);
        Item savedItem = itemService.createItem(item);
        ItemDTO responseBody = convertItemToItemDTO(savedItem);
        return new ResponseEntity<ItemDTO>(responseBody, HttpStatus.CREATED);

    }

    @PostMapping(value = "/itemList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDTO>> createMultipleItems(@RequestBody List<ItemDTO> itemDTOS) {

        List<Item> items = new ArrayList<>();
        itemDTOS.forEach(itemDTO -> items.add(convertItemDTOToItem(itemDTO)));
        List<Item> createdItems = itemService.createMultipleItems(items);
        List<ItemDTO> responseBody = new ArrayList<>();
        createdItems.forEach(item -> responseBody.add(convertItemToItemDTO(item)));
        return new ResponseEntity<List<ItemDTO>>(responseBody, HttpStatus.CREATED);

    }

    @GetMapping(value = "/{itemId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> getItemDetailsByItemId(@PathVariable(value = "itemId") int itemId)
            throws ItemNotFoundForGivenIdException {

        Item foundItem = itemService.getItemDetailsByItemId(itemId);
        ItemDTO responseBody = convertItemToItemDTO(foundItem);
        return new ResponseEntity<ItemDTO>(responseBody, HttpStatus.OK);

    }

    @GetMapping(value = "/itemName/{itemName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> getItemDetailsByItemName(@PathVariable(value = "itemName") String itemName)
            throws ItemWithThisNameNotFoundException {

        Item foundItem = itemService.getItemDetailsByItemName(itemName);
        ItemDTO responseBody = convertItemToItemDTO(foundItem);
        return new ResponseEntity<ItemDTO>(responseBody, HttpStatus.OK);

    }

    @GetMapping(value = "/itemCost/{itemCost}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDTO>> getListOfItemsOfTheSameCost(@PathVariable(value = "itemCost") double itemCost)
            throws NoItemFoundAtThisCostException {

        List<Item> foundItems = itemService.getListOfItemsOfTheSameCost(itemCost);
        List<ItemDTO> responseBody = new ArrayList<>();
        foundItems.forEach(item -> responseBody.add(convertItemToItemDTO(item)));
        return new ResponseEntity<List<ItemDTO>>(responseBody, HttpStatus.OK);

    }

    @GetMapping(value = "/itemCategory/{itemCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDTO>> getListOfItemsOfTheSameCategory(@PathVariable(value = "itemCategory") String itemCategory)
            throws NoItemFoundWithTheGivenCategoryException {

        List<Item> foundItems = itemService.getListOfItemsOfTheSameCategory(itemCategory);
        List<ItemDTO> responseBody = new ArrayList<>();
        foundItems.forEach(item -> responseBody.add(convertItemToItemDTO(item)));
        return new ResponseEntity<List<ItemDTO>>(responseBody, HttpStatus.OK);

    }

    @GetMapping(value = "/mfgDate/{mfgDate}")
    public ResponseEntity<String> getListOfItemsProducedOnTheSameMfgDate(@PathVariable(value = "mfgDate") String mfgDate) {

        return new ResponseEntity<String>("This API is currently under construction", HttpStatus.OK);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDTO>> getAllItems()
            throws NoItemExistsException {

        List<Item> foundItems = itemService.getListOfAllItems();
        List<ItemDTO> responseBody = new ArrayList<>();
        foundItems.forEach(item -> responseBody.add(convertItemToItemDTO(item)));
        return new ResponseEntity<List<ItemDTO>>(responseBody, HttpStatus.OK);

    }

    @PutMapping(value = "/{itemId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> updateItem(@PathVariable(value = "itemId") int itemId, @RequestBody ItemDTO itemDTO)
            throws ItemNotFoundForGivenIdException {

        Item itemUpdater = convertItemDTOToItem(itemDTO);
        Item updatedItem = itemService.updateItem(itemId, itemUpdater);
        ItemDTO responseBody = convertItemToItemDTO(updatedItem);
        return new ResponseEntity<ItemDTO>(responseBody, HttpStatus.ACCEPTED);

    }

    @DeleteMapping(value = "/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable(value = "itemId") int itemId)
            throws ItemNotFoundForGivenIdException {

        itemService.deleteItem(itemId);
        return new ResponseEntity<String>("Item with id : [" + itemId + "] , successfully deleted", HttpStatus.OK);

    }

    @PutMapping(value = "/{itemId}/cart/{cartId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDTO> addItemToGivenCart(@PathVariable(value = "itemId") int itemId,
                                                      @PathVariable(value = "cartId") int cartId)

            throws ItemNotFoundForGivenIdException, CartNotFoundForGivenIdException {

        Cart foundCart = itemService.addItemToGivenCart(itemId, cartId);
        CartDTO responseBody = convertCartToCartDTO(foundCart);
        return new ResponseEntity<CartDTO>(responseBody, HttpStatus.ACCEPTED);

    }

    @PutMapping(value = "/itemIds/cart/{cartId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDTO> addMultipleItemsToGivenCart(@RequestBody List<Integer> itemIds, @PathVariable(value = "cartId") int cartId)
            throws CartNotFoundForGivenIdException {

        Cart updatedCart = itemService.addMultipleItemsToGivenCart(itemIds, cartId);
        CartDTO responseBody = convertCartToCartDTO(updatedCart);
        return new ResponseEntity<CartDTO>(responseBody, HttpStatus.ACCEPTED);

    }

    private ItemDTO convertItemToItemDTO(Item item) {
        return modelMapper.map(item, ItemDTO.class);
    }

    private Item convertItemDTOToItem(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, Item.class);
    }

    private CartDTO convertCartToCartDTO(Cart cart) {
        return modelMapper.map(cart, CartDTO.class);
    }

}
