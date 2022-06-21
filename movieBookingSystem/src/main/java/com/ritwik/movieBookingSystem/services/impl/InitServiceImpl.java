package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.entities.*;
import com.ritwik.movieBookingSystem.exceptions.*;
import com.ritwik.movieBookingSystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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

    Theatre theatre = new Theatre();

    Movie movie = new Movie();

    Users user = new Users();

    MovieTheatre movieTheatre = new MovieTheatre();

    List<Language> languages = List.of(
            new Language("ENGLISH"),
            new Language("HINDI"));

    List<City> cities = Arrays.asList(
            new City("patna"),
            new City("bangalore"),
            new City("kolkata"),
            new City("mumbai"));

    @Override
    public void init() throws
            UserTypeDetailsNotFoundException,
            UserNameAlreadyExistsException,
            MovieTheatreDetailsNotFoundException,
            UserDetailsNotFoundException,
            MovieDetailsNotFoundException,
            TheatreDetailsNotFoundException {

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

        createUsers();

        /**
         * add theatres
         */

        createTheatres();

        /**
         * add movie-theatres
         */

        createMovieTheatres();

        /**
         * add bookings
         */

        createBookings();

        /**
         * add languages
         */

        createLanguages();

    }

    private void createLanguages() {
        languages.forEach(language -> languageService.acceptLanguageDetails(language));
    }

    private void createBookings() throws MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException {
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setMovieTheatre(movieTheatre);
        booking.setNoOfSeats(120);
        booking.setBookingDate(LocalDateTime.of(2022, 6, 21, 16, 42));
        bookingService.acceptBookingDetails(booking);
    }

    private void createMovieTheatres() throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException {
        movieTheatre.setTheatre(theatre);
        movieTheatre.setMovie(movie);
        movieTheatreService.acceptMovieTheatreDetails(movieTheatre);
    }

    private void createTheatres() {
        theatre.setTheatreName("pvr");
        theatre.setTicketPrice(300);
        theatre.setCity(new City("ranchi"));
        theatreService.acceptTheatreDetails(theatre);
    }

    private void createUsers() throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
        user.setFirstName("Ritwik");
        user.setLastName("chatterjee");
        user.setUsername("ritwik123");
        user.setPassword("Ritwik@123");
        user.setPhoneNumbers(Set.of(123, 456, 789));
        user.setDateOfBirth(LocalDateTime.of(2000, 4, 30, 12, 30));
        user.setUserType(userTypes.get(1));
        user.setLanguage(languages.get(1));

        userService.acceptUserDetails(user);
    }

    private void createMovies() {
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
        userTypes.forEach(userType -> userTypeService.acceptUserTypeDetails(userType));
    }

    private void createCities() {
        cities.forEach(city -> cityService.acceptCityDetails(city));
    }
}
