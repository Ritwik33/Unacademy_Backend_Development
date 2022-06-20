package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.dao.UserDao;
import com.ritwik.movieBookingSystem.dao.UserTypeDao;
import com.ritwik.movieBookingSystem.entities.Users;
import com.ritwik.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.ritwik.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.UserService;
import org.hibernate.procedure.UnknownSqlResultSetMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTypeDao userTypeDao;

    @Override
    public Users acceptUserDetails(Users user) throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
        if(userDao.findByUsername(user.getUsername()).isPresent()) {
            throw new UserNameAlreadyExistsException("this username is already taken");
        }
        return userDao.save(user);
    }

    @Override
    public Users getUserDetails(int id) throws UserDetailsNotFoundException {
        return userDao.findById(id).
                orElseThrow(() -> new UserDetailsNotFoundException("user not found for id " + id));
    }

    @Override
    public Users getUserDetailsByName(String username) throws UserDetailsNotFoundException {
        return userDao.findByUsername(username).
                orElseThrow(() -> new UserDetailsNotFoundException("user not found for username : " + username));
    }

    @Override
    public Users updateUserDetails(int id, Users user) throws UserDetailsNotFoundException, UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
        return null;
    }
}
