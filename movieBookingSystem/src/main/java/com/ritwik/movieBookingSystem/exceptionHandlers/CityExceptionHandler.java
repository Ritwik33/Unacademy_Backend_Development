package com.ritwik.movieBookingSystem.exceptionHandlers;

import com.ritwik.movieBookingSystem.exceptions.CityDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityExceptionHandler.class);

    @ExceptionHandler(value = CityDetailsNotFoundException.class)
    public ResponseEntity<String> handleCityDetailsNotFoundException() {
        LOGGER.error("Exception happened, city details not found for the given id");
        return new ResponseEntity<String>("No city found for the given id", HttpStatus.BAD_REQUEST);
    }
}
