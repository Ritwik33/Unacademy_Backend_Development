package com.ritwik.movieBookingSystem.dao;

import com.ritwik.movieBookingSystem.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeDao extends JpaRepository<UserType, Integer> {

}
