package com.ritwik.movieBookingSystem.services;

import com.ritwik.movieBookingSystem.entities.Users;
import com.ritwik.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.ritwik.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;

public interface UserService {

    /**
     * allow the creation of users
     * I should also not be allowed to:
     * 1. create an existing user
     * 2. I should not be allowed to create a user of wrong type
     */

    public Users acceptUserDetails(Users users) throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException;

    /**
     * fetch the user details based on the user id
     */

    public Users getUserDetails(int id) throws UserDetailsNotFoundException;

    /**
     * fetch the user by there name
     */

    public Users getUserDetailsByName(String username) throws UserDetailsNotFoundException;

    /**
     * update the user details
     */

    public Users updateUserDetails(int id, Users users) throws UserDetailsNotFoundException, UserNameAlreadyExistsException, UserTypeDetailsNotFoundException;
}
