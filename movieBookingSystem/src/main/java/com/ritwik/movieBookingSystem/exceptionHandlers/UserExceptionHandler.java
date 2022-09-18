package com.ritwik.movieBookingSystem.exceptionHandlers;

import com.ritwik.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserExceptionHandler.class);

    @ExceptionHandler(value = UserNameAlreadyExistsException.class)
    public ResponseEntity<String> handleUserNameAlreadyExistsException() {
        LOGGER.error("exception happened, user name already exists");
        return new ResponseEntity<String>("username already exists", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserDetailsNotFoundException.class)
    public ResponseEntity<String> handleUserDetailsNotFoundException() {
        LOGGER.error("exception happened, user not found for the given id");
        return new ResponseEntity<String>("user not found for the given id", HttpStatus.BAD_REQUEST);
    }


}
