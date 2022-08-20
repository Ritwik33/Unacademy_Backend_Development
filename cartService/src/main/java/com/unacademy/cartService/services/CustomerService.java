package com.unacademy.cartService.services;

import com.unacademy.cartService.entities.Customer;
import com.unacademy.cartService.exceptions.CustomerWithThisIdNotFoundException;
import com.unacademy.cartService.exceptions.NoCustomerExistsException;
import com.unacademy.cartService.exceptions.NoCustomerFoundWithThisNameException;

import java.util.List;

public interface CustomerService {

    public Customer createCustomer(Customer customer);

    public List<Customer> createMultipleCustomers(List<Customer> customers);

    public Customer getCustomerDetailsByCustomerId(int customerId) throws CustomerWithThisIdNotFoundException;

    public List<Customer> getCustomersDetailsByCustomerName(String customerName) throws NoCustomerFoundWithThisNameException;

    public List<Customer> getAllCustomers() throws NoCustomerExistsException;

    public Customer updateCustomerDetails(int customerId, Customer customer) throws CustomerWithThisIdNotFoundException;

    public boolean deleteCustomer(int customerId) throws CustomerWithThisIdNotFoundException;

}
