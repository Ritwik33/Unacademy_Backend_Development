package com.unacademy.cartService.exceptionHandlers;

import com.unacademy.cartService.exceptions.CustomerWithThisIdNotFoundException;
import com.unacademy.cartService.exceptions.NoCustomerExistsException;
import com.unacademy.cartService.exceptions.NoCustomerFoundWithThisNameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerControllerExceptionHandler.class);

    @ExceptionHandler(value = CustomerWithThisIdNotFoundException.class)
    public ResponseEntity<String> handleCustomerWithThisIdNotFoundException() {
        LOGGER.error("Exception happened, No customer found for the customer Id passed");
        return new ResponseEntity<String>("No Customer found for the given id", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoCustomerFoundWithThisNameException.class)
    public ResponseEntity<String> handleNoCustomerFoundWithThisNameException() {
        LOGGER.error("Exception happened, No customer found with the given name");
        return new ResponseEntity<String>("No Customer found with the given name", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoCustomerExistsException.class)
    public ResponseEntity<String> handleNoCustomerExistsException() {
        LOGGER.error("Exception happened, No Customer exists in the database as of now");
        return new ResponseEntity<String>("No Customer exists as of now", HttpStatus.BAD_REQUEST);
    }

}
