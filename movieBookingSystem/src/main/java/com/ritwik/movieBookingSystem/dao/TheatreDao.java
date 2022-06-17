package com.ritwik.movieBookingSystem.dao;

import com.ritwik.movieBookingSystem.entities.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreDao extends JpaRepository<Theatre, Integer> {

}
