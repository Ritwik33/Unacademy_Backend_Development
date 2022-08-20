package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.daos.MovieTheatreDao;
import com.ritwik.movieBookingSystem.entities.MovieTheatre;
import com.ritwik.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.MovieService;
import com.ritwik.movieBookingSystem.services.MovieTheatreService;
import com.ritwik.movieBookingSystem.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieTheatreServiceImpl implements MovieTheatreService {

    @Autowired
    private MovieTheatreDao movieTheatreDao;

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheatreService theatreService;

    @Override
    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre) throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException {
        movieService.getMovieDetails(movieTheatre.getMovie().getMovieId());
        theatreService.getTheatreDetails(movieTheatre.getTheatre().getTheatreId());
        return movieTheatreDao.save(movieTheatre);
    }

    @Override
    public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException {
        return movieTheatreDao.findById(id).orElseThrow(() -> new MovieTheatreDetailsNotFoundException("Movie theatre not found by id: " + id));
    }

    @Override
    public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException {
        MovieTheatre movieTheatre = getMovieTheatreDetails(id);
        movieTheatreDao.delete(movieTheatre);
        return true;
    }

    @Override
    public List<MovieTheatre> getAllMovieTheatreDetails() {
        return movieTheatreDao.findAll();
    }
}
