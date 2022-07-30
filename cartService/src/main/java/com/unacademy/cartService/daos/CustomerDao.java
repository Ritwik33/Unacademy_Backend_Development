package com.unacademy.cartService.daos;

import com.unacademy.cartService.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

    public List<Customer> findByCustomerName(String customerName);

}
