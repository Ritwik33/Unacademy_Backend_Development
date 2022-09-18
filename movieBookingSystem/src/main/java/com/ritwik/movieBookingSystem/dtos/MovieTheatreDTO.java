package com.ritwik.movieBookingSystem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieTheatreDTO {

    @JsonProperty(value = "movie_theatre_id")
    private int movieTheatreId;

    private MovieDTO movie;

    private TheatreDTO theatre;

    public int getMovieTheatreId() {
        return movieTheatreId;
    }

    public void setMovieTheatreId(int movieTheatreId) {
        this.movieTheatreId = movieTheatreId;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    public TheatreDTO getTheatre() {
        return theatre;
    }

    public void setTheatre(TheatreDTO theatre) {
        this.theatre = theatre;
    }

    @Override
    public String toString() {
        return "MovieTheatreDTO{" +
                "movieTheatreId=" + movieTheatreId +
                ", movie=" + movie +
                ", theatre=" + theatre +
                '}';
    }
}
