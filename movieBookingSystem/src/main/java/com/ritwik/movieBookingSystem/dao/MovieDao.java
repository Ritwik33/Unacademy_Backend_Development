package com.ritwik.movieBookingSystem.dao;

import com.ritwik.movieBookingSystem.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieDao extends JpaRepository<Movie, Integer> {

    /**
     * i also want to support the search based on the movie name
     */

    public List<Movie> findByMovieName(String movieName);

    /**
     * I want to query based on multiple columns
     * query based on name and duration
     */

    public List<Movie> findByMovieNameAndDuration(String name, int duration);

    /**
     * find the movie with duration greater than given hour
     */

    public List<Movie> findByDurationGreaterThanEqual(int duration);
}
