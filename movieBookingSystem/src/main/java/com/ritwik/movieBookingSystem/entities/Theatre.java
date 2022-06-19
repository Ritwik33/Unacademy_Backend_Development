package com.ritwik.movieBookingSystem.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Theatre {

    @Id
    @GeneratedValue
    private int theatreId;

    @Column(length = 20, nullable = false, unique = true)
    private String theatreName;

    @Column(nullable = false)
    private float ticketPrice = 150.00f;

    @ManyToMany(mappedBy = "theatres")
    private List<Movie> movies;

    /**
     * foreign key
     */

    /**
     * default strategy will be eager
     */

    @ManyToOne
//  @Column(name = "city_id") -> @Column can't be used on a many-to-one property ...
    @JoinColumn(name = "city_id", nullable = false) // @JoinColumn is used on a foreign key column ...
    private City city;

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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreId=" + theatreId +
                ", theatreName='" + theatreName + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", movies=" + movies +
                ", city=" + city +
                '}';
    }
}
