package com.ritwik.movieBookingSystem.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Status {

    @Id
    @GeneratedValue
    private int statusId;

    @Column(length = 20, nullable = false, unique = true)
    private String statusName;

    @OneToMany(mappedBy = "status")
    private List<Movie> movies;

    public Status() {
    }

    public Status(String statusName) {
        this.statusName = statusName;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                ", movies=" + movies +
                '}';
    }
}
