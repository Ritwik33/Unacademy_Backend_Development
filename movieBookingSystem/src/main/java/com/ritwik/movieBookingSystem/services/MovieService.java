package com.ritwik.movieBookingSystem.services;

import com.ritwik.movieBookingSystem.entities.Movie;
import com.ritwik.movieBookingSystem.exceptions.MovieDetailsNotFoundException;

import java.util.List;

/**
 * this interface will define methods supported by MovieService
 */

public interface MovieService {

    /**
     * it should be able to take a movie request and save it to the database ...
     */

    public Movie acceptMovieDetails(Movie movie);

    /**
     * i want to get the movie details based on movie id
     */

    public Movie getMovieDetails(int id) throws MovieDetailsNotFoundException;

    /**
     * get movie details by movieName
     */

    public List<Movie> getMovieDetailsByMovieName(String movieName) throws MovieDetailsNotFoundException;

    /**
     * I want to update the details of existing movie
     */

    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException;

    /**
     * I want to have a method to delete a movie
     */

    public boolean deleteMovie(int id) throws MovieDetailsNotFoundException;

    /**
     * I want to get the list of all the movies present
     */

    public List<Movie> getAllMovies();

}
