package com.ritwik.movieBookingSystem.services;

import com.ritwik.movieBookingSystem.entities.MovieTheatre;
import com.ritwik.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;

import java.util.List;

public interface MovieTheatreService {

    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre) throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException;
    public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException;
    public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException;
    public List<MovieTheatre> getAllMovieTheatreDetails();

}
