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
    private UserTypeService userTypeService;

    @Autowired
    private UserService userService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private CityService cityService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private MovieTheatreService movieTheatreService;

    @Autowired
    private BookingService bookingService;

    List<UserType> userTypes = Arrays.asList(
            new UserType("CUSTOMER"),
            new UserType("ADMIN")
    );

    Users user1 = new Users();
    Users user2 = new Users();

    List<Status> statuses = Arrays.asList(
            new Status("RELEASED"),
            new Status("UPCOMING"),
            new Status("BLOCKED")
    );

    List<Language> languages = Arrays.asList(
            new Language("ENGLISH"),
            new Language("HINDI"),
            new Language("PUNJABI"),
            new Language("FRENCH"),
            new Language("BENGALI")
    );

    List<City> cities = Arrays.asList(
            new City("Mumbai"),
            new City("Delhi"),
            new City("Kolkata"),
            new City("Bangalore"),
            new City("Chennai")
    );

    Movie movie1 = new Movie();
    Movie movie2 = new Movie();
    Movie movie3 = new Movie();

    Theatre theatre1 = new Theatre();
    Theatre theatre2 = new Theatre();
    Theatre theatre3 = new Theatre();

    List<MovieTheatre> movieTheatres = Arrays.asList(
            new MovieTheatre(movie1, theatre1),
            new MovieTheatre(movie2, theatre2),
            new MovieTheatre(movie3, theatre3)
    );

    List<Booking> bookings = Arrays.asList(
            new Booking(LocalDateTime.of(2022, 6, 28, 15, 34), 2, user1, movieTheatres.get(0)),
            new Booking(LocalDateTime.of(2022, 6, 28, 15, 35), 3, user2, movieTheatres.get(1))
    );

    @Override
    public void init() throws UserTypeDetailsNotFoundException, UserNameAlreadyExistsException {

        /**
         * create userTypes
         */

        createUserTypes();

        /**
         * create languages
         */

        createLanguages();

        /**
         * create users
         */

        createUsers();

        /**
         * create statuses
         */

        createStatuses();

        /**
         * create cities
         */

        createCities();

        /**
         * create movies
         */

        createMovies();

        /**
         * create theatres
         */

        createTheatres();

        /**
         * create MovieTheatres
         */

        createMovieTheatres();

        /**
         * create Bookings
         */

        createBookings();

    }

    private void createBookings() {
        bookings.forEach(booking -> {
            try {
                bookingService.acceptBookingDetails(booking);
            } catch (MovieTheatreDetailsNotFoundException e) {
                throw new RuntimeException(e);
            } catch (UserDetailsNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void createMovieTheatres() {
        movieTheatres.forEach(movieTheatre -> {
            try {
                movieTheatreService.acceptMovieTheatreDetails(movieTheatre);
            } catch (MovieDetailsNotFoundException e) {
                throw new RuntimeException(e);
            } catch (TheatreDetailsNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void createTheatres() {
        theatre1.setTheatreName("Pvr");
        theatre1.setTicketPrice(250);
        theatre1.setCity(cities.get(0));
        theatre1.setMovies(List.of(movie1, movie2));

        theatreService.acceptTheatreDetails(theatre1);

        theatre2.setTheatreName("Inox");
        theatre2.setTicketPrice(500);
        theatre2.setCity(cities.get(1));
        theatre2.setMovies(List.of(movie2, movie3));

        theatreService.acceptTheatreDetails(theatre2);

        theatre3.setTheatreName("Carnival");
        theatre3.setTicketPrice(1000);
        theatre3.setCity(cities.get(2));
        theatre3.setMovies(List.of(movie1, movie3));

        theatreService.acceptTheatreDetails(theatre3);
    }

    private void createMovies() {
        movie1.setMovieName("captain america first avenger");
        movie1.setMovieDescription("steve rogers becomes captain america");
        movie1.setDuration(120);
        movie1.setReleaseDate(LocalDateTime.of(2022, 6, 28, 15, 9));
        movie1.setTrailerUrl("http://www.captainAmericaFirstAvengerTrailerUrl.com");
        movie1.setCoverPhotoUrl("http://www.captainAmericaFirstAvengerCoverPhotoUrl.com");
        movie1.setStatus(statuses.get(0));

        movieService.acceptMovieDetails(movie1);

        movie2.setMovieName("captain america civil war");
        movie2.setMovieDescription("captain and tony fights over sokovia accords");
        movie2.setDuration(360);
        movie2.setReleaseDate(LocalDateTime.of(2022, 6, 28, 15, 13));
        movie2.setTrailerUrl("http://www.captainAmericaCivilWarTrailerUrl.com");
        movie2.setCoverPhotoUrl("http://www.captainAmericaCivilWarCoverPhotoUrl.com");
        movie2.setStatus(statuses.get(1));

        movieService.acceptMovieDetails(movie2);

        movie3.setMovieName("captain america winter soldier");
        movie3.setMovieDescription("captain finds bucky");
        movie3.setDuration(120);
        movie3.setReleaseDate(LocalDateTime.of(2022, 6, 28, 15, 15));
        movie3.setTrailerUrl("http://www.captainAmericaWinterSoldierTrailerUrl.com");
        movie3.setCoverPhotoUrl("http://www.captainAmericaWinterSoldierCoverPhotoUrl.com");
        movie3.setStatus(statuses.get(2));

        movieService.acceptMovieDetails(movie3);
    }

    private void createCities() {
        cities.forEach(city -> cityService.acceptCityDetails(city));
    }

    private void createLanguages() {
        languages.forEach(language -> languageService.acceptLanguageDetails(language));
    }

    private void createStatuses() {
        statuses.forEach(status -> statusService.acceptStatusDetails(status));
    }

    private void createUsers() throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
        user1.setFirstName("Ritwik");
        user1.setLastName("Chatterjee");
        user1.setDateOfBirth(LocalDateTime.of(2000, 4, 30, 12, 30));
        user1.setUsername("Ritwik@123");
        user1.setPassword("mango@551");
        user1.setPhoneNumbers(Set.of(123, 456, 789));
        user1.setUserType(userTypes.get(1));
        user1.setLanguage(languages.get(0));

        userService.acceptUserDetails(user1);

        user2.setFirstName("Rishi");
        user2.setLastName("Chatterjee");
        user2.setDateOfBirth(LocalDateTime.of(2007, 11, 7, 3, 40));
        user2.setUsername("Rishi@711");
        user2.setPassword("orange@786");
        user2.setPhoneNumbers(Set.of(321, 654, 987));
        user2.setUserType(userTypes.get(0));
        user2.setLanguage(languages.get(0));

        userService.acceptUserDetails(user2);
    }

    private void createUserTypes() {
        userTypes.forEach(userType -> userTypeService.acceptUserTypeDetails(userType));
    }

}
