package com.ritwik.movieBookingSystem.services;

import com.ritwik.movieBookingSystem.entities.UserType;
import com.ritwik.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;

import java.util.List;

public interface UserTypeService {

    public UserType acceptUserTypeDetails(UserType userType);
    public UserType getUserTypeDetails(int id) throws UserTypeDetailsNotFoundException;
    public UserType getUserTypeDetailsByUserTypeName(String userTypeName) throws UserTypeDetailsNotFoundException;
    public boolean deleteUserType(int id) throws UserTypeDetailsNotFoundException;
    public List<UserType> getAllUserTypeDetails();

}
