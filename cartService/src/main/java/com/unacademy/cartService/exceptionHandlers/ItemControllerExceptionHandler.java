package com.unacademy.cartService.exceptionHandlers;

import com.unacademy.cartService.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemControllerExceptionHandler.class);

    @ExceptionHandler(value = ItemNotFoundForGivenIdException.class)
    public ResponseEntity<String> handleItemNotFoundForGivenIdException() {
        LOGGER.error("Exception happened, No Item found for the given id");
        return new ResponseEntity<String>("No Item found for the given Id", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ItemWithThisNameNotFoundException.class)
    public ResponseEntity<String> handleItemWithThisNameNotFoundException() {
        LOGGER.error("Exception happened, No item found with the given name");
        return new ResponseEntity<String>("No Item found for the given name", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoItemFoundAtThisCostException.class)
    public ResponseEntity<String> handleNoItemFoundAtThisCostException() {
        LOGGER.error("Exception happened, No item found at the given cost");
        return new ResponseEntity<String>("No Item found at the given cost", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoItemFoundWithTheGivenCategoryException.class)
    public ResponseEntity<String> handleNoItemFoundWithTheGivenCategoryException() {
        LOGGER.error("Exception happened, No item of the given category found");
        return new ResponseEntity<String>("No Item of the given category found", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoItemExistsException.class)
    public ResponseEntity<String> handleNoItemExistsException() {
        LOGGER.error("Exception happened, No item exists in the database as of now");
        return new ResponseEntity<String>("No item exists as of now", HttpStatus.BAD_REQUEST);
    }

}
