package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.daos.BookingDao;
import com.ritwik.movieBookingSystem.entities.Booking;
import com.ritwik.movieBookingSystem.exceptions.BookingDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.BookingService;
import com.ritwik.movieBookingSystem.services.MovieTheatreService;
import com.ritwik.movieBookingSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    public MovieTheatreService movieTheatreService;

    @Autowired
    public UserService userService;

    @Autowired
    public BookingDao bookingDao;

    @Override
    public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException {
        movieTheatreService.getMovieTheatreDetails(booking.getMovieTheatre().getMovieTheatreId());
        userService.getUserDetails(booking.getUser().getUserId());
        return bookingDao.save(booking);
    }

    @Override
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException {
        return bookingDao.findById(id).orElseThrow(() -> new BookingDetailsNotFoundException("Booking not found for id: " + id));
    }

    @Override
    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException {
        Booking booking = getBookingDetails(id);
        bookingDao.delete(booking);
        return true;
    }

    @Override
    public List<Booking> getAllBookingDetails() {
        return bookingDao.findAll();
    }
}
