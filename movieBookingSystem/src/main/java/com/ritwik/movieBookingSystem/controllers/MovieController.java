package com.ritwik.movieBookingSystem.controllers;

import com.ritwik.movieBookingSystem.dtos.MovieDTO;
import com.ritwik.movieBookingSystem.entities.Movie;
import com.ritwik.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.MovieService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/mbs/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        List<MovieDTO> movieDTOS = new ArrayList<>();
        movies.forEach(movie -> movieDTOS.add(convertMovieToMovieDTO(movie)));
        return new ResponseEntity<List<MovieDTO>> (movieDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{movieId}")
    public ResponseEntity<MovieDTO> getMovieBasedOnId(@PathVariable(value = "movieId") int movieId)
            throws MovieDetailsNotFoundException {

        Movie searchedMovie = null;

        try {
            searchedMovie = movieService.getMovieDetails(movieId);
        } catch (MovieDetailsNotFoundException e) {
            LOGGER.error("bad request found for id : " + movieId);
            LOGGER.error("error stack trace: " + e.getMessage());
            return new ResponseEntity ("movie_id : [ " + movieId + " ] is not correct", HttpStatus.BAD_REQUEST);
        }

        MovieDTO responseBody = convertMovieToMovieDTO(searchedMovie);
        return new ResponseEntity<MovieDTO> (responseBody, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO) {

        Movie movie = convertMovieDTOToMovie(movieDTO);
        Movie savedMovie = movieService.acceptMovieDetails(movie);
        MovieDTO responseBody = convertMovieToMovieDTO(savedMovie);
        return new ResponseEntity<MovieDTO> (responseBody, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{movieId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> updateMovie(@RequestBody MovieDTO movieDTO, @PathVariable(value = "movieId") int movieId)
            throws MovieDetailsNotFoundException {

        Movie searchedMovie = movieService.getMovieDetails(movieId);
        Movie movieUpdater = convertMovieDTOToMovie(movieDTO);
        Movie updatedMovie = movieService.updateMovieDetails(movieId, movieUpdater);
        MovieDTO responseBody = convertMovieToMovieDTO(updatedMovie);
        return new ResponseEntity<MovieDTO> (responseBody, HttpStatus.ACCEPTED);

    }

    @DeleteMapping(value = "/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable(value = "movieId") int movieId)
            throws MovieDetailsNotFoundException {

        movieService.deleteMovie(movieId);
        return new ResponseEntity<String> ("Movie Deleted", HttpStatus.OK);

    }

    private Movie convertMovieDTOToMovie(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, Movie.class);
    }

    private MovieDTO convertMovieToMovieDTO(Movie movie) {
        return modelMapper.map(movie, MovieDTO.class);
    }

}
