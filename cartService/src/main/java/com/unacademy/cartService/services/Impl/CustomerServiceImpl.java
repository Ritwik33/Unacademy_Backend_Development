package com.unacademy.cartService.services.Impl;

import com.unacademy.cartService.daos.CustomerDao;
import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Customer;
import com.unacademy.cartService.exceptions.CartNotFoundForGivenCustomerException;
import com.unacademy.cartService.exceptions.CustomerWithThisIdNotFoundException;
import com.unacademy.cartService.exceptions.NoCustomerFoundWithThisNameException;
import com.unacademy.cartService.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public List<Customer> createMultipleCustomers(List<Customer> customers) {
        List<Customer> savedCustomers = new ArrayList<Customer>();
        customers.forEach(customer -> savedCustomers.add(customerDao.save(customer)));
        return savedCustomers;
    }

    @Override
    public Customer getCustomerDetailsByCustomerId(int customerId) throws CustomerWithThisIdNotFoundException {
        return customerDao.findById(customerId).orElseThrow(() ->
                new CustomerWithThisIdNotFoundException("Customer not found for id: " + customerId));
    }

    @Override
    public List<Customer> getCustomersDetailsByCustomerName(String customerName) throws
            NoCustomerFoundWithThisNameException {

        List<Customer> foundCustomers = customerDao.findByCustomerName(customerName);
        if(foundCustomers == null) {
            throw new NoCustomerFoundWithThisNameException("no customer found with name: " + customerName);
        }
        return foundCustomers;

    }

    @Override
    public Customer updateCustomerDetails(int customerId, Customer customer) throws
            CustomerWithThisIdNotFoundException {

        Customer searchedCustomer = getCustomerDetailsByCustomerId(customerId);

        if(customer.getCustomerName() != null) {
            searchedCustomer.setCustomerName(customer.getCustomerName());
        }

        return customerDao.save(searchedCustomer);
    }

    @Override
    public boolean deleteCustomer(int customerId) throws CustomerWithThisIdNotFoundException {
        Customer searchedCustomer = getCustomerDetailsByCustomerId(customerId);
        customerDao.delete(searchedCustomer);
        return true;
    }
}
