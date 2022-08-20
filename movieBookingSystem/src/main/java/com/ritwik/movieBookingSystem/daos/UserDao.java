package com.ritwik.movieBookingSystem.daos;

import com.ritwik.movieBookingSystem.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<Users, Integer> {
    public Optional<Users> findByUsername(String username);
}
