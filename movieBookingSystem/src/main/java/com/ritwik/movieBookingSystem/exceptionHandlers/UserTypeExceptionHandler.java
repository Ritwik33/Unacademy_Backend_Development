package com.ritwik.movieBookingSystem.exceptionHandlers;

import com.ritwik.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserTypeExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserTypeExceptionHandler.class);

    @ExceptionHandler(value = UserTypeDetailsNotFoundException.class)
    public ResponseEntity<String> handleUserTypeDetailsNotFoundException() {
        LOGGER.error("exception happened, user type details not found");
        return new ResponseEntity<String>("user type details not found for the given id", HttpStatus.BAD_REQUEST);
    }


}
