package com.unacademy.cartService.daos;

import com.unacademy.cartService.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
