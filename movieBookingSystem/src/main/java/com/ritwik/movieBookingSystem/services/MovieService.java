package com.ritwik.movieBookingSystem.services;

import com.ritwik.movieBookingSystem.entities.Movie;

/**
 * this interface will define methods supported by MovieService
 */

public interface MovieService {
    /**
     * it should be able to take a movie request and save it to the database ...
     */

    public Movie acceptMovieDetails(Movie movie);

    
}
