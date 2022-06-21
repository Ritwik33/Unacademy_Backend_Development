package com.ritwik.movieBookingSystem.service.impl;

import com.ritwik.movieBookingSystem.entities.Movie;
import com.ritwik.movieBookingSystem.entities.Status;
import com.ritwik.movieBookingSystem.services.MovieService;
import com.ritwik.movieBookingSystem.services.StatusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * this class will be used to write the test cases of the MovieServiceImpl class ...
 */

@SpringBootTest
public class MovieServiceImplTest {

    @Autowired
    private MovieService movieService;

    @Autowired
    private StatusService statusService;

    Movie movie;

    @BeforeEach
    public void beforeEachTest() {
        movie = new Movie();
        movie.setMovieName("movie");
        movie.setMovieDescription("movie_description");
        movie.setDuration(120);
        movie.setReleaseDate(LocalDateTime.of(2022, 6, 22, 0, 25));
        movie.setTrailerUrl("movie_trailer_url");
        movie.setCoverPhotoUrl("movie_cover_photo_url");
        Status status = new Status();
        status.setStatusName("UNRELEASED");
        statusService.acceptStatusDetails(status);
        movie.setStatus(status);
    }

    /**
     * test acceptMovieDetails
     */

    @Test
    public void testAcceptMovieDetails() {

        /**
         * check if this method is able to save a movie ...
         */

        Movie savedMovie = movieService.acceptMovieDetails(movie);

        Assertions.assertNotNull(savedMovie);
        Assertions.assertNotNull(savedMovie.getMovieId());

    }

    /**
     * test getMovieDetails
     */

    /**
     * test updateMovieDetails
     */

    /**
     * test deleteMovie
     */

    /**
     * test getAllMovies
     */
}
