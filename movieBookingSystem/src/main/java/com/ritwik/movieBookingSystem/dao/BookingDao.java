package com.ritwik.movieBookingSystem.dao;

import com.ritwik.movieBookingSystem.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking, Integer> {

}
