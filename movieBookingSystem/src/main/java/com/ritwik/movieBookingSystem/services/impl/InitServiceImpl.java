package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.entities.*;
import com.ritwik.movieBookingSystem.exceptions.*;
import com.ritwik.movieBookingSystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private CityService cityService;

    @Autowired
    private UserTypeService userTypeService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private MovieTheatreService movieTheatreService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private LanguageService languageService;

    List<Status> statuses = Arrays.asList(
            new Status("UPCOMING"),
            new Status("RELEASED"),
            new Status("BLOCKED"));

    List<UserType> userTypes = Arrays.asList(
            new UserType("Customer"),
            new UserType("Admin"));

    List<City> cities = Arrays.asList(
            new City("patna"),
            new City("bangalore"),
            new City("kolkata"),
            new City("mumbai"));

    @Override
    public void init() {

        /**
         * write the logic to store data inside the database in different tables ...
         */

        /**
         * add cities
         */

        createCities();

        /**
         * add user types
         */

        createUserTypes();

        /**
         * add statuses
         */

        createStatuses();

        /**
         * add movies
         */

        /**
         *  add users
         */

        /**
         * add theatres
         */

        /**
         * add movie-theatres
         */

        /**
         * add bookings
         */

        /**
         * add languages
         */

    }

    private void createStatuses() {
        statuses.forEach(status -> statusService.acceptStatusDetails(status));
    }

    private void createUserTypes() {
        userTypes.forEach(userType -> userTypeService.acceptUserTypeDetails(userType));
    }

    private void createCities() {
        cities.forEach(city -> cityService.acceptCityDetails(city));
    }
}
