package com.unacademy.cartService.controllers;

import com.unacademy.cartService.dtos.ItemDTO;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.ItemNotFoundForGivenIdException;
import com.unacademy.cartService.exceptions.NoItemExistsException;
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

    @GetMapping(value = "/{itemId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> getItemDetailsByItemId(@PathVariable(value = "itemId") int itemId)
            throws ItemNotFoundForGivenIdException {

        Item foundItem = itemService.getItemDetailsByItemId(itemId);
        ItemDTO responseBody = convertItemToItemDTO(foundItem);
        return new ResponseEntity<ItemDTO>(responseBody, HttpStatus.OK);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDTO>> getAllItems()
            throws NoItemExistsException {

        List<Item> foundItems = itemService.getListOfAllItems();
        List<ItemDTO> responseBody = new ArrayList<>();
        foundItems.forEach(item -> responseBody.add(convertItemToItemDTO(item)));
        return new ResponseEntity<List<ItemDTO>>(responseBody, HttpStatus.OK);

    }

    private ItemDTO convertItemToItemDTO(Item item) {
        return modelMapper.map(item, ItemDTO.class);
    }

    private Item convertItemDTOToItem(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, Item.class);
    }

}
