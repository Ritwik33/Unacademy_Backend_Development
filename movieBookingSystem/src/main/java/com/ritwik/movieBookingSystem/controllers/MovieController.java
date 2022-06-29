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
@RequestMapping("/mbs/v1/movies")
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    /**
     * we need to define the bean of ModelMapper first ...
     *
     * How to create the bean of a class which I have not created ???
     * ---> create a method to return a ModelMapper Object and annotate that method with @Bean annotation ...
     */

    @Autowired
    private ModelMapper modelMapper;

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
    public ResponseEntity<List<MovieDTO>> getAllMovies() {

        List<Movie> movies = movieService.getAllMovies();

        List<MovieDTO> movieDTOS = new ArrayList<>();

        movies.forEach(movie -> movieDTOS.add(convertMovieToMovieDTO(movie)));

        return new ResponseEntity<List<MovieDTO>>(movieDTOS, HttpStatus.OK);

    }

    /**
     * get the movie details based on the id
     *
     * GET 127.0.0.1:8080/mbs/v1/movies/{movieId}
     */

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDTO> getMovieBasedOnId(@PathVariable(name = "movieId") int movieId) throws MovieDetailsNotFoundException {

        Movie movie = movieService.getMovieDetails(movieId);

        /**
         * convert the Movie Object to MovieDto Object ...
         */

        MovieDTO movieDTO = convertMovieToMovieDTO(movie);

        return new ResponseEntity<MovieDTO>(movieDTO, HttpStatus.OK);

    }

    /**
     * I want to create a new Movie
     *
     *  URI : POST 127.0.0.1:8080/mbs/v1/movies
     *
     *  BODY:
     *    {
     *       ----
     *       ----
     *       ----
     *    }
     *
     */

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO) {

        /**
         * logic to create the movie
         */

        /**
         * I need to create the new movie
         */

        /**
         * i need to create movie object from movieDTO
         */

        Movie movie = convertMovieDTOToMovie(movieDTO);
        Movie savedMovie = movieService.acceptMovieDetails(movie);

        MovieDTO responseBody = convertMovieToMovieDTO(savedMovie);

        return new ResponseEntity<MovieDTO>(responseBody, HttpStatus.CREATED);

    }



    private MovieDTO convertMovieToMovieDTO(Movie movie) {

        MovieDTO movieDTO =  modelMapper.map(movie, MovieDTO.class);
        return movieDTO;

    }

    private Movie convertMovieDTOToMovie(MovieDTO movieDTO) {
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        return movie;
    }

}
