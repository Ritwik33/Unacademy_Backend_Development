package com.ritwik.movieBookingSystem.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityId;

    @Column(length = 20, nullable = false)
    private String cityName;

    /**
     * default fetch strategy will be lazy
     */

//  @OneToMany --> this annotation leads to the creation of an additional table city_theatres which is redundant ...
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER) // mapped by the city table primary key ...
    private Set<Theatre> theatres;

    public City() {
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(Set<Theatre> theatres) {
        this.theatres = theatres;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityName.equals(city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName);
    }
}
