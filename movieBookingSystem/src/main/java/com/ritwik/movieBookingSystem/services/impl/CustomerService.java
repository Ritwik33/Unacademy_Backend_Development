package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.entities.Customer;
import com.ritwik.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.ritwik.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;

public interface CustomerService {

    /**
     * allow the creation of users
     * I should also not be allowed to:
     * 1. create an existing user
     * 2. I should not be allowed to create a user of wrong type
     */

    public Customer acceptUserDetails(Customer customer) throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException;

    /**
     * fetch the user details based on the user id
     */

    public Customer getUserDetails(int id) throws UserDetailsNotFoundException;

    /**
     * fetch the user by there name
     */

    public Customer getUserDetailsByName(String username) throws UserDetailsNotFoundException;

    /**
     * update the user details
     */

    public Customer updateUserDetails(int id, Customer customer) throws UserDetailsNotFoundException, UserNameAlreadyExistsException, UserNameAlreadyExistsException;
}
