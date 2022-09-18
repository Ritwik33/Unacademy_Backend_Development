package com.ritwik.movieBookingSystem.exceptionHandlers;

import com.ritwik.movieBookingSystem.exceptions.LanguageDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LanguageExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageExceptionHandler.class);

    @ExceptionHandler(value = LanguageDetailsNotFoundException.class)
    public ResponseEntity<String> handleLanguageDetailsNotFoundException() {
        LOGGER.error("exception happened, language not found for the given id");
        return new ResponseEntity<String>("No language found for the given id", HttpStatus.BAD_REQUEST);
    }
}
