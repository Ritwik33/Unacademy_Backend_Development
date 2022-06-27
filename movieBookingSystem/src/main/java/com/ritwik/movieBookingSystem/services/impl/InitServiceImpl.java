package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.entities.*;
import com.ritwik.movieBookingSystem.exceptions.*;
import com.ritwik.movieBookingSystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    List<City> cities = Arrays.asList(
            new City("patna"),
            new City("bangalore"),
            new City("kolkata"),
            new City("mumbai"),
            new City("ranchi"));

    List<Language> languages = Arrays.asList(
            new Language("ENGLISH"),
            new Language("HINDI"),
            new Language("PUNJABI")
    );

    List<Theatre> theatres = Arrays.asList(
            new Theatre("pvr", 300, cities.get(4)),
            new Theatre("inox", 500, cities.get(3)),
            new Theatre("plasma", 1000, cities.get(2))
    );

    Movie movie = new Movie();

    MovieTheatre movieTheatre = new MovieTheatre();

    Users user = new Users();

    @Override
    public void init() throws UserTypeDetailsNotFoundException, UserNameAlreadyExistsException, MovieDetailsNotFoundException, TheatreDetailsNotFoundException, MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException {

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
         * add theatres
         */

        createTheatres();

        /**
         * add movies
         */

        createMovies();

        /**
         * add languages
         */

        createLanguages();

        /**
         *  add users
         */

        createUsers();

        /**
         * add movie-theatres
         */

        createMovieTheatres();

        /**
         * add bookings
         */

        createBookings();

    }

    private void createBookings() throws MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException {
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setMovieTheatre(movieTheatre);
        booking.setBookingDate(LocalDateTime.of(2022, 6, 21, 18, 19));
        booking.setNoOfSeats(120);

        bookingService.acceptBookingDetails(booking);
    }

    private void createMovieTheatres() throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException {

        movieTheatre.setMovie(movie);
        movieTheatre.setTheatre(theatres.get(0));

        movieTheatreService.acceptMovieTheatreDetails(movieTheatre);
    }

    private void createTheatres() {
        theatres.forEach(theatre -> theatreService.acceptTheatreDetails(theatre));
    }

    private void createLanguages() {
        languages.forEach(language -> languageService.acceptLanguageDetails(language));
    }

    private void createUsers() throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {

        user.setFirstName("ritwik");
        user.setLastName("chatterjee");
        user.setDateOfBirth(LocalDateTime.of(2000, 4, 30, 12, 30));
        user.setUsername("ritwik123");
        user.setPassword("Ritwik@123");
        user.setUserType(userTypes.get(0));
        user.setLanguage(languages.get(0));
        user.setPhoneNumbers(Set.of(123, 456, 789));

        userService.acceptUserDetails(user);
    }

    private void createMovies() {
        movie.setMovieName("movie_name");
        movie.setMovieDescription("movie_description");
        movie.setStatus(statuses.get(2));
        movie.setDuration(120);
        movie.setReleaseDate(LocalDateTime.of(2022, 6, 21, 17, 36));
        movie.setCoverPhotoUrl("movie_cover_photo_url");
        movie.setTrailerUrl("movie_trailer_url");
        movie.setTheatres(List.of(theatres.get(0), theatres.get(1)));

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
