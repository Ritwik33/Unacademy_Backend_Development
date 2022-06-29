package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.daos.MovieDao;
import com.ritwik.movieBookingSystem.entities.Movie;
import com.ritwik.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    /**
     * to talk with the database, I need the help of MovieDao
     * @param movie
     * @return
     */

    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie acceptMovieDetails(Movie movie) {

        /**
         * with the help of movieDao save into db
         */

        return movieDao.save(movie);
    }

    @Override
    public Movie getMovieDetails(int id) throws MovieDetailsNotFoundException {

        /**
         * fetch the movie details based on id
         */

        return movieDao.findById(id).orElseThrow(() -> new MovieDetailsNotFoundException("Movie not found for id" + id));
    }

    @Override
    public Movie getMovieDetailsByMovieName(String movieName) throws MovieDetailsNotFoundException {
         Movie savedMovie = (Movie) movieDao.findByMovieName(movieName);
         if(savedMovie == null) {
             throw new MovieDetailsNotFoundException("Movie not found by name: " + movieName);
         }
         return savedMovie;
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException {
        /**
         * update the movie
         */

        Movie savedMovie =
                movieDao.findById(id).orElseThrow(() -> new MovieDetailsNotFoundException("Movie not found for id" + id));

        /**
         * read the attributes from the movie object and update it in savedMovie ...
         */

        if(isNotNullOrZero(movie.getMovieName())) {
            savedMovie.setMovieName(movie.getMovieName());
        }

        if(isNotNullOrZero(movie.getMovieDescription())) {
            savedMovie.setMovieDescription(movie.getMovieDescription());
        }

        if(isNotNullOrZero(movie.getDuration())) {
            savedMovie.setDuration(movie.getDuration());
        }

        if(isNotNullOrZero(movie.getCoverPhotoUrl())) {
            savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        }

        if(isNotNullOrZero(movie.getReleaseDate())) {
            savedMovie.setReleaseDate(movie.getReleaseDate());
        }

        if(isNotNullOrZero(movie.getStatus())) {
            savedMovie.setStatus(movie.getStatus());
        }

        if(isNotNullOrZero(movie.getTrailerUrl())) {
            savedMovie.setTrailerUrl(movie.getTrailerUrl());
        }

        return movieDao.save(savedMovie);
    }

    @Override
    public boolean deleteMovie(int id) throws MovieDetailsNotFoundException {
        Movie savedMovie = getMovieDetails(id);
        movieDao.delete(savedMovie);
        return true;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }

}
