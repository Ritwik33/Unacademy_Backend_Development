package com.ritwik.movieBookingSystem.dao;

import com.ritwik.movieBookingSystem.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDao extends JpaRepository<Car, Integer> {

}
