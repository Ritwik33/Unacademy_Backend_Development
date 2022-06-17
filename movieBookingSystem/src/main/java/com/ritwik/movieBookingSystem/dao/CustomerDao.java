package com.ritwik.movieBookingSystem.dao;

import com.ritwik.movieBookingSystem.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
