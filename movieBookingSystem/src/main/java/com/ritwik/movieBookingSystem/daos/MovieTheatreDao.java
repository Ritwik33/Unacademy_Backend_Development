package com.ritwik.movieBookingSystem.daos;

import com.ritwik.movieBookingSystem.entities.MovieTheatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheatreDao extends JpaRepository<MovieTheatre, Integer> {
}
