package com.ritwik.movieBookingSystem.exceptionHandlers;

import com.ritwik.movieBookingSystem.exceptions.InvalidMovieNameException;
import com.ritwik.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
/**
 *  1. creates the bean of this class and makes it available
 *  2. everytime an exception is thrown this class will be informed
 */
public class MovieExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieExceptionHandler.class);

    /**
     * this annotation indicates to this method that if the given exception
     * happens below method should be called ...
     * @return
     */
    @ExceptionHandler(value = MovieDetailsNotFoundException.class)
    public ResponseEntity<String> handleMovieDetailsNotFoundException() {
        LOGGER.error("Exception happened, movie id is not available");
        return new ResponseEntity<String>("Movie ID passed is not available", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidMovieNameException.class)
    public ResponseEntity<String> handleInvalidMovieNameException() {
        LOGGER.error("Exception happened, Invalid Movie Name");
        return new ResponseEntity<String>("Movie name not passed / Invalid", HttpStatus.BAD_REQUEST);
    }

}
