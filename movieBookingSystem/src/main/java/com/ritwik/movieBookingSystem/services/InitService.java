package com.ritwik.movieBookingSystem.services;

import com.ritwik.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.ritwik.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;

public interface InitService {

    public void init() throws UserTypeDetailsNotFoundException, UserNameAlreadyExistsException;

}
