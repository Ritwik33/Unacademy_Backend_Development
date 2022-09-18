package com.ritwik.movieBookingSystem.exceptionHandlers;

import com.ritwik.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieTheatreExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieTheatreExceptionHandler.class);

    @ExceptionHandler(value = MovieTheatreDetailsNotFoundException.class)
    public ResponseEntity<String> handleMovieTheatreDetailsNotFoundException() {
        LOGGER.error("exception happened, movie theatre details not found for the given id");
        return new ResponseEntity<String>("No movie theatre found for the given id", HttpStatus.BAD_REQUEST);
    }


}
