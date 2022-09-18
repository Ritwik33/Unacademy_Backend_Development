package com.ritwik.movieBookingSystem.exceptionHandlers;

import com.ritwik.movieBookingSystem.exceptions.*;
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
        LOGGER.error("Exception happened, movie id/name is not available");
        return new ResponseEntity<String>("No movie found with the passed movie id/name", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidMovieNameException.class)
    public ResponseEntity<String> handleInvalidMovieNameException() {
        LOGGER.error("Exception happened, Invalid Movie Name");
        return new ResponseEntity<String>("Movie name not passed / Invalid", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidMovieDurationException.class)
    public ResponseEntity<String> handleInvalidMovieDurationException() {
        LOGGER.error("Exception happened, Invalid Movie Duration");
        return new ResponseEntity<String>("Invalid Movie duration", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidMovieDescriptionException.class)
    public ResponseEntity<String> handleInvalidMovieDescriptionException() {
        LOGGER.error("Exception happened, Invalid movie description");
        return new ResponseEntity<String>("Empty/Invalid Movie Description", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidCoverPhotoUrlException.class)
    public ResponseEntity<String> handleInvalidCoverPhotoUrlException() {
        LOGGER.error("Exception happened, Invalid cover photo url");
        return new ResponseEntity<String>("Empty/ invalid cover photo url", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidTrailerUrlException.class)
    public ResponseEntity<String> handleInvalidTrailerUrlException() {
        LOGGER.error("Exception happened, Invalid trailer url");
        return new ResponseEntity<String>("Empty/ invalid trailer url", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidReleaseDateException.class)
    public ResponseEntity<String> handleInvalidReleaseDateException() {
        LOGGER.error("Exception happened, Invalid release date");
        return new ResponseEntity<String>("Empty release date", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidStatusIdException.class)
    public ResponseEntity<String> handleInvalidStatusIdException() {
        LOGGER.error("Exception happened, Invalid status id passed");
        return new ResponseEntity<String>("Invalid status id passed", HttpStatus.BAD_REQUEST);
    }

}
