package com.ritwik.movieBookingSystem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class BookingDTO {

    @JsonProperty(value = "booking-id")
    private int bookingId;

    @JsonProperty(value = "booking-date")
    private LocalDateTime bookingDate;

    @JsonProperty(value = "no-of-seats")
    private int noOfSeats;

    private UserDTO user;

    @JsonProperty(value = "movie-theatre")
    private MovieTheatreDTO movieTheatre;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public MovieTheatreDTO getMovieTheatre() {
        return movieTheatre;
    }

    public void setMovieTheatre(MovieTheatreDTO movieTheatre) {
        this.movieTheatre = movieTheatre;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", noOfSeats=" + noOfSeats +
                ", user=" + user +
                ", movieTheatre=" + movieTheatre +
                '}';
    }
}
