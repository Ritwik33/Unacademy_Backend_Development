package com.ritwik.movieBookingSystem.exceptions;

public class MovieDetailsNotFoundException extends Exception {

    public MovieDetailsNotFoundException(String s) {

    }

    @Override
    public String getMessage() {
        return "Movie details not found";
    }

}
