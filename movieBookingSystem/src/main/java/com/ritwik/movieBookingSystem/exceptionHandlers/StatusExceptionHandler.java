package com.ritwik.movieBookingSystem.exceptionHandlers;

import com.ritwik.movieBookingSystem.exceptions.StatusDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StatusExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusExceptionHandler.class);

    @ExceptionHandler(value = StatusDetailsNotFoundException.class)
    public ResponseEntity<String> handleStatusDetailsNotFoundException() {
        LOGGER.error("exception happened, status not found for the given id");
        return new ResponseEntity<String>("No status found for the given id", HttpStatus.BAD_REQUEST);
    }
}
