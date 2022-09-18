package com.ritwik.movieBookingSystem.exceptionHandlers;

import com.ritwik.movieBookingSystem.exceptions.NoTheatreContainingThisStringException;
import com.ritwik.movieBookingSystem.exceptions.NoTheatreFoundAtThisPriceException;
import com.ritwik.movieBookingSystem.exceptions.NoTheatreFoundWithTheGivenNameException;
import com.ritwik.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TheatreExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TheatreExceptionHandler.class);

    @ExceptionHandler(value = TheatreDetailsNotFoundException.class)
    public ResponseEntity<String> handleTheatreDetailsNotFoundException() {
        LOGGER.error("exception happened, no theatre found for the given id");
        return new ResponseEntity<String>("No theatre found for the given id", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoTheatreFoundWithTheGivenNameException.class)
    public ResponseEntity<String> handleNoTheatreFoundWithTheGivenNameException() {
        LOGGER.error("exception happened, no theatre found with the given name");
        return new ResponseEntity<String>("No theatre found for the given name", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoTheatreFoundAtThisPriceException.class)
    public ResponseEntity<String> handleNoTheatreFoundAtThisPriceException() {
        LOGGER.error("exception happened, no theatre found at the given ticket price");
        return new ResponseEntity<String>("No theatre found at the given ticket price", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoTheatreContainingThisStringException.class)
    public ResponseEntity<String> handleNoTheatreContainingThisStringException() {
        LOGGER.error("exception happened, no theatre name found containing the given string");
        return new ResponseEntity<String>("No theatre name found containing the given string", HttpStatus.BAD_REQUEST);
    }


}
