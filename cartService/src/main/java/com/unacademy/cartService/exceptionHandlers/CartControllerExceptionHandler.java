package com.unacademy.cartService.exceptionHandlers;

import com.unacademy.cartService.exceptions.CartNotFoundForGivenIdException;
import com.unacademy.cartService.exceptions.NoCartExistsException;
import com.unacademy.cartService.exceptions.NoCartFoundForGivenCustomerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CartControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartControllerExceptionHandler.class);

    @ExceptionHandler(value = CartNotFoundForGivenIdException.class)
    public ResponseEntity<String> handleCartNotFoundForGivenIdException() {
        LOGGER.error("Exception happened, No Cart found for the cart Id passed");
        return new ResponseEntity<String>("No Cart found for the given Id", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoCartFoundForGivenCustomerException.class)
    public ResponseEntity<String> handleNoCartFoundForGivenCustomerException() {
        LOGGER.error("Exception happened, No Cart found for the customer details passed");
        return new ResponseEntity<String>("No Cart found for the given Customer Details", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoCartExistsException.class)
    public ResponseEntity<String> handleNoCartExistsException() {
        LOGGER.error("Exception happened, No cart exists in the database as of now");
        return new ResponseEntity<String>("No Cart exists as of now", HttpStatus.BAD_REQUEST);
    }

}
