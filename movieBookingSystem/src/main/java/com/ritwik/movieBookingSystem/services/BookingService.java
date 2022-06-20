package com.ritwik.movieBookingSystem.services;

import com.ritwik.movieBookingSystem.entities.Booking;
import com.ritwik.movieBookingSystem.exceptions.BookingDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.UserDetailsNotFoundException;

import java.util.List;

public interface BookingService {

    public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException;

    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException;

    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException;

    public List<Booking> getAllBookingDetails();
}
