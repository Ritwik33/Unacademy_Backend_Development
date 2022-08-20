package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.daos.UserDao;
import com.ritwik.movieBookingSystem.entities.Users;
import com.ritwik.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.ritwik.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.UserService;
import com.ritwik.movieBookingSystem.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTypeService userTypeService;

    @Override
    public Users acceptUserDetails(Users user) throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
        if(userDao.findByUsername(user.getUsername()).isPresent()) {
            throw new UserNameAlreadyExistsException("this username is already taken");
        }
        userTypeService.getUserTypeDetails(user.getUserType().getUserTypeId());
        return userDao.save(user);
    }

    @Override
    public Users getUserDetails(int id) throws UserDetailsNotFoundException {
        return userDao.findById(id).
                orElseThrow(() -> new UserDetailsNotFoundException("user not found for id " + id));
    }

    @Override
    public Users getUserDetailsByUserName(String username) throws UserDetailsNotFoundException {
        return userDao.findByUsername(username).
                orElseThrow(() -> new UserDetailsNotFoundException("user not found for username : " + username));
    }

    @Override
    public Users updateUserDetails(int id, Users user) throws UserDetailsNotFoundException, UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
        Users savedUser = getUserDetails(id);

        if(userDao.findByUsername(user.getUsername()).isPresent()) {
            throw new UserNameAlreadyExistsException("This username is already taken");
        }

        userTypeService.getUserTypeDetails(user.getUserType().getUserTypeId());

        if(isNotNullOrZero(user.getFirstName())) {
            savedUser.setFirstName(user.getFirstName());
        }

        if(isNotNullOrZero(user.getLastName())) {
            savedUser.setLastName(user.getLastName());
        }

        if(isNotNullOrZero(user.getUsername())) {
            savedUser.setUsername(user.getUsername());
        }

        if(isNotNullOrZero(user.getPassword())) {
            savedUser.setPassword(user.getPassword());
        }

        if(isNotNullOrZero(user.getUserType())) {
            savedUser.setUserType(user.getUserType());
        }

        if(isNotNullOrZero(user.getDateOfBirth())) {
            savedUser.setDateOfBirth(user.getDateOfBirth());
        }

        if(isNotNullOrZero(user.getLanguage())) {
            savedUser.setLanguage(savedUser.getLanguage());
        }

        if(isNotNullOrZero(user.getPhoneNumbers())) {
            savedUser.setPhoneNumbers(savedUser.getPhoneNumbers());
        }

        return userDao.save(savedUser);
    }

    public boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }

    @Override
    public boolean deleteUser(int id) throws UserDetailsNotFoundException {
        Users savedUser = getUserDetails(id);
        userDao.delete(savedUser);
        return true;
    }

    @Override
    public List<Users> getAllUserDetails() {
        return userDao.findAll();
    }
}
