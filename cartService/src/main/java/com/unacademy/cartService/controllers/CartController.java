package com.unacademy.cartService.controllers;

import com.unacademy.cartService.dtos.CartDTO;
import com.unacademy.cartService.dtos.CustomerDTO;
import com.unacademy.cartService.dtos.ItemDTO;
import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Customer;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.CartNotFoundForGivenIdException;
import com.unacademy.cartService.exceptions.NoCartExistsException;
import com.unacademy.cartService.exceptions.NoCartFoundForGivenCustomerException;
import com.unacademy.cartService.services.Impl.CartServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/carts")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDTO> createCart(@RequestBody CartDTO cartDTO) {

        Cart cart = convertCartDTOToCart(cartDTO);
        Cart savedCart = cartService.createCart(cart);
        CartDTO responseBody = convertCartToCartDTO(savedCart);
        return new ResponseEntity<CartDTO>(responseBody, HttpStatus.CREATED);

    }

    @PostMapping(value = "/cartList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CartDTO>> createMultipleCarts(@RequestBody List<CartDTO> cartDTOS) {

        List<Cart> carts = new ArrayList<>();
        cartDTOS.forEach(cartDTO -> carts.add(convertCartDTOToCart(cartDTO)));
        List<Cart> savedCarts = cartService.createMultipleCarts(carts);
        List<CartDTO> responseBody = new ArrayList<>();
        savedCarts.forEach(cart -> responseBody.add(convertCartToCartDTO(cart)));
        return new ResponseEntity<List<CartDTO>>(responseBody, HttpStatus.CREATED);

    }

    @GetMapping(value = "/{cartId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDTO> getCartDetailsByCartId(@PathVariable(value = "cartId") int cartId)
            throws CartNotFoundForGivenIdException {

        Cart foundCart = cartService.getCartDetailsByCartId(cartId);
        CartDTO responseBody = convertCartToCartDTO(foundCart);
        return new ResponseEntity<CartDTO>(responseBody, HttpStatus.OK);

    }

    @GetMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDTO> getCartDetailsByCustomer(@RequestBody CustomerDTO customerDTO)
            throws NoCartFoundForGivenCustomerException {

        Customer customer = convertCustomerDTOToCustomer(customerDTO);
        Cart foundCart = cartService.getCartDetailsByCustomer(customer);
        CartDTO responseBody = convertCartToCartDTO(foundCart);
        return new ResponseEntity<CartDTO>(responseBody, HttpStatus.OK);

    }

    @GetMapping(value = "/{cartId}/itemList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDTO>> getListOfAllItemsInTheCart(@PathVariable(value = "cartId") int cartId)
            throws CartNotFoundForGivenIdException {

        List<Item> items = cartService.getListOfAllItemsInTheCart(cartId);
        List<ItemDTO> responseBody = new ArrayList<>();
        items.forEach(item -> responseBody.add(convertItemToItemDTO(item)));
        return new ResponseEntity<List<ItemDTO>>(responseBody, HttpStatus.OK);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CartDTO>> getAllCarts() throws NoCartExistsException {

        List<Cart> foundCarts = cartService.getAllCarts();
        List<CartDTO> responseBody = new ArrayList<>();
        foundCarts.forEach(cart -> responseBody.add(convertCartToCartDTO(cart)));
        return new ResponseEntity<List<CartDTO>>(responseBody, HttpStatus.OK);

    }

    @GetMapping(value = "/{cartId}/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> getCustomerByCartId(@PathVariable(value = "cartId") int cartId)
            throws CartNotFoundForGivenIdException {

        CustomerDTO responseBody = convertCustomerToCustomerDTO(cartService.getCustomerByCartId(cartId));
        return new ResponseEntity<CustomerDTO>(responseBody, HttpStatus.OK);

    }

    @PutMapping(value = "/{cartId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDTO> updateCart(@PathVariable(value = "cartId") int cartId, @RequestBody CartDTO cartDTO)
            throws CartNotFoundForGivenIdException {

        Cart cartUpdater = convertCartDTOToCart(cartDTO);
        Cart updatedCart = cartService.updateCart(cartId, cartUpdater);
        CartDTO responseBody = convertCartToCartDTO(updatedCart);
        return new ResponseEntity<CartDTO>(responseBody, HttpStatus.ACCEPTED);

    }

    @DeleteMapping(value = "/{cartId}")
    public ResponseEntity<String> deleteCart(@PathVariable(value = "cartId") int cartId) throws CartNotFoundForGivenIdException {

        cartService.deleteCart(cartId);
        return new ResponseEntity<String>("Cart with id : [" + cartId + "], successfully deleted", HttpStatus.OK);

    }

    @DeleteMapping(value = "/{cartId}/itemList/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> removeItemFromGivenCart(@PathVariable(value = "itemId") int itemId, @PathVariable(value = "cartId") int cartId) {

        return new ResponseEntity<String>("This API is currently under construction", HttpStatus.OK);

    }

    private Cart convertCartDTOToCart(CartDTO cartDTO) {
        return modelMapper.map(cartDTO, Cart.class);
    }

    private CartDTO convertCartToCartDTO(Cart cart) {
        return modelMapper.map(cart, CartDTO.class);
    }

    private Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }

    private CustomerDTO convertCustomerToCustomerDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    private ItemDTO convertItemToItemDTO(Item item) {
        return modelMapper.map(item, ItemDTO.class);
    }

}
