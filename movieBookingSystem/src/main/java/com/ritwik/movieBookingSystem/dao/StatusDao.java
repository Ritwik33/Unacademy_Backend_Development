package com.ritwik.movieBookingSystem.dao;

import com.ritwik.movieBookingSystem.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDao extends JpaRepository<Status, Integer> {

}
