package com.ritwik.movieBookingSystem.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue
    private int bookingId;

    @Column(nullable = false)
    private LocalDateTime bookingDate;

    @Column(nullable = false)
    private int noOfSeats;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "movie_theatre_id", nullable = false)
    private MovieTheatre movieTheatre;

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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public MovieTheatre getMovieTheatre() {
        return movieTheatre;
    }

    public void setMovieTheatre(MovieTheatre movieTheatre) {
        this.movieTheatre = movieTheatre;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", noOfSeats=" + noOfSeats +
                ", user=" + user +
                ", movieTheatre=" + movieTheatre +
                '}';
    }
}
