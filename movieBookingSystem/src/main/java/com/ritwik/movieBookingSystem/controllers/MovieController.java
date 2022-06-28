package com.ritwik.movieBookingSystem.controllers;

import com.ritwik.movieBookingSystem.entities.Movie;
import com.ritwik.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mbs/v1/movies")
public class MovieController {

    private static Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @GetMapping("/greetings")
    public ResponseEntity<String> greetings() {
        LOGGER.info("inside the hello world method");
        return new ResponseEntity<String>("hello people", HttpStatus.OK);
    }

    /**
     * get all the movies
     *
     * GET 127.0.0.1:8080/mbs/v1/movies
     *
     * @return
     */

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    /**
     * get the movie details based on the id
     *
     * GET 127.0.0.1:8080/mbs/v1/movies/{movieId}
     */

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieBasedOnId(@PathVariable(name = "movieId") int movieId) throws MovieDetailsNotFoundException {

        /**
         * I should not use Movie class to return the response to the client
         * this is not a good practice ...
         */

        /**
         * use entities for talking to database and use dtos for talking to clients ...
         */

        return new ResponseEntity<Movie>(movieService.getMovieDetails(movieId), HttpStatus.OK);

    }



}
