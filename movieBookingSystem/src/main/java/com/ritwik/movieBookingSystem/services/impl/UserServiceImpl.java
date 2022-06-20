package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.dao.UserDao;
import com.ritwik.movieBookingSystem.entities.Users;
import com.ritwik.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.ritwik.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Users acceptUserDetails(Users users) throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
        return null;
    }

    @Override
    public Users getUserDetails(int id) throws UserDetailsNotFoundException {
        return userDao.findById(id).orElseThrow(() -> new UserDetailsNotFoundException("user not found for id " + id));
    }

    @Override
    public Users getUserDetailsByName(String username) throws UserDetailsNotFoundException {
        return userDao.findByUsername(username).orElseThrow(() -> new UserDetailsNotFoundException("user not found for username : " + username));
    }

    @Override
    public Users updateUserDetails(int id, Users users) throws UserDetailsNotFoundException, UserNameAlreadyExistsException, UserNameAlreadyExistsException {
        return null;
    }
}
