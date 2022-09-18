package com.ritwik.movieBookingSystem.exceptionHandlers;

import com.ritwik.movieBookingSystem.exceptions.BookingDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookingExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingExceptionHandler.class);

    @ExceptionHandler(value = BookingDetailsNotFoundException.class)
    public ResponseEntity<String> handleBookingDetailsNotFoundException() {
        LOGGER.error("Exception happened, booking not found for given id");
        return new ResponseEntity<String>("No booking found for the given id", HttpStatus.BAD_REQUEST);
    }

}
