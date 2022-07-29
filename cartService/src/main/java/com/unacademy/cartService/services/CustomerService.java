package com.unacademy.cartService.services;

import com.unacademy.cartService.entities.Customer;

public interface CustomerService {

    public Customer createCustomer(Customer customer);

    public Customer findByCustomerId(int customerId);

    public boolean deleteCustomer(int customerId);

}
