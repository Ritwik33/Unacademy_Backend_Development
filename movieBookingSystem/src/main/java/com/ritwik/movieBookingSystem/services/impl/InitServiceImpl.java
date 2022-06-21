package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.entities.*;
import com.ritwik.movieBookingSystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

        createMovies();

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

    private void createMovies() {
        Movie movie = new Movie();
        movie.setMovieName("movie_name");
        movie.setTrailerUrl("movie_trailer_url");
        movie.setStatus(statuses.get(1));
        movie.setMovieDescription("movie_description");
        movie.setCoverPhotoUrl("movie_cover_photo_url");
        movie.setDuration(120);
        movie.setReleaseDate(LocalDateTime.of(2022, 06, 21, 15, 07));
        movieService.acceptMovieDetails(movie);
    }

    private void createStatuses() {
        statuses.forEach(status -> statusService.acceptStatusDetails(status));
    }

    private void createUserTypes() {
        List<UserType> userTypes = new ArrayList<>();
        userTypes.add(new UserType("Customer"));
        userTypes.add(new UserType("Admin"));

        userTypes.forEach(userType -> userTypeService.acceptUserTypeDetails(userType));
    }

    private void createCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("patna"));
        cities.add(new City("bangalore"));
        cities.add(new City("kolkata"));
        cities.add(new City("mumbai"));

        cities.forEach(city -> cityService.acceptCityDetails(city));
    }
}
