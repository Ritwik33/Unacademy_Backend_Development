package com.ritwik.movieBookingSystem.services;

import com.ritwik.movieBookingSystem.exceptions.*;

/**
 * this will be used to initialize data in all the tables of the MBA
 */

public interface InitService {

    /**
     * this method when called will initialize the data in the DB
     */

    public void init() throws UserTypeDetailsNotFoundException, UserNameAlreadyExistsException, MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException, MovieDetailsNotFoundException, TheatreDetailsNotFoundException;

}
