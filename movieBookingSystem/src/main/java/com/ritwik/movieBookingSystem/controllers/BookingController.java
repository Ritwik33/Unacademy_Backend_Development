package com.ritwik.movieBookingSystem.controllers;

import com.ritwik.movieBookingSystem.dtos.BookingDTO;
import com.ritwik.movieBookingSystem.entities.Booking;
import com.ritwik.movieBookingSystem.exceptions.BookingDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.impl.BookingServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    private BookingServiceImpl bookingService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingDTO> acceptBookingDetails(@RequestBody BookingDTO bookingDTO)
            throws MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException {
        Booking bookingToBeSaved = convertBookingDTOToBooking(bookingDTO);
        Booking savedBooking = bookingService.acceptBookingDetails(bookingToBeSaved);
        BookingDTO responseBody = convertBookingToBookingDTO(savedBooking);
        return new ResponseEntity<BookingDTO>(responseBody, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingDTO> getBookingDetails(@PathVariable(value = "bookingId") int bookingId)
            throws BookingDetailsNotFoundException {
        Booking foundBooking = bookingService.getBookingDetails(bookingId);
        BookingDTO responseBody = convertBookingToBookingDTO(foundBooking);
        return new ResponseEntity<BookingDTO>(responseBody, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteBooking(@PathVariable(value = "bookingId") int bookingId)
            throws BookingDetailsNotFoundException {
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity<String>("booking deleted", HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookingDTO>> getAllBookingDetails() {
        List<Booking> bookings = bookingService.getAllBookingDetails();
        List<BookingDTO> responseBody = new ArrayList<>();
        bookings.forEach(booking -> responseBody.add(convertBookingToBookingDTO(booking)));
        return new ResponseEntity<List<BookingDTO>>(responseBody, HttpStatus.OK);
    }

    private BookingDTO convertBookingToBookingDTO(Booking booking) {
        return modelMapper.map(booking, BookingDTO.class);
    }

    private Booking convertBookingDTOToBooking(BookingDTO bookingDTO) {
        return modelMapper.map(bookingDTO, Booking.class);
    }
}
