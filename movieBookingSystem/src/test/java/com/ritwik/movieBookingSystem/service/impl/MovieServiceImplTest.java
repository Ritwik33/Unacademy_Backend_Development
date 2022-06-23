package com.ritwik.movieBookingSystem.service.impl;

import com.ritwik.movieBookingSystem.dao.MovieDao;
import com.ritwik.movieBookingSystem.dao.StatusDao;
import com.ritwik.movieBookingSystem.entities.Movie;
import com.ritwik.movieBookingSystem.entities.Status;
import com.ritwik.movieBookingSystem.services.impl.MovieServiceImpl;
import com.ritwik.movieBookingSystem.services.impl.StatusServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class MovieServiceImplTest {

    /**
     * MovieServiceImpl, it depends on MovieDao
     *
     * We need to create a dummy of MovieDao and replace original MovieDao present in MovieServiceImpl
     */

    /**
     * this is the dummy or mocked MovieDao
     */

    @Mock
    private MovieDao movieDao;

    @Mock
    private StatusDao statusDao;

    /**
     * this creates the MovieServiceImpl object with mocked MovieDao
     */

    @InjectMocks
    private MovieServiceImpl movieService;

    @InjectMocks
    private StatusServiceImpl statusService;

    private Movie movie;

    @BeforeEach
    public void beforeEachTest() {

        movie = new Movie();
        movie.setMovieName("movie");
        movie.setMovieDescription("movie_description");
        movie.setDuration(120);
        movie.setReleaseDate(LocalDateTime.of(2022, 6, 22, 0, 25));
        movie.setTrailerUrl("movie_trailer_url");
        movie.setCoverPhotoUrl("movie_cover_photo_url");
        Status status = new Status("UNRELEASED");
        status.setStatusName("UNRELEASED");
        Mockito.when(statusDao.save(status)).thenReturn(status);
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


        /**
         * not a true case of unit testing
         * this is integration testing because acceptMovieDetails uses movieDao to save movie into DB
         */

        /**
         * adding the functionality on MovieDao
         *
         * it says to MovieDao, when save method is called, just return the object back
         *
         * this doesn't involve actually calling the database
         */

        Mockito.when(movieDao.save(movie)).thenReturn(movie);

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
