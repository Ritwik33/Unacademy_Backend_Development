package com.ritwik.movieBookingSystem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TheatreDTO {

    @JsonProperty(value = "theatre_id")
    private int theatreId;

    @JsonProperty(value = "theatre_name")
    private String theatreName;

    @JsonProperty(value = "ticket_price")
    private float ticketPrice;

    private List<MovieDTO> movies;

    private CityDTO city;

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "TheatreDTO{" +
                "theatreId=" + theatreId +
                ", theatreName='" + theatreName + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", movies=" + movies +
                ", city=" + city +
                '}';
    }
}
