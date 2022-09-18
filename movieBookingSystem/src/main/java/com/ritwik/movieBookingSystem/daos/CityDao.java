package com.ritwik.movieBookingSystem.daos;

import com.ritwik.movieBookingSystem.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityDao extends JpaRepository<City, Integer> {
    public List<City> findByCityName(String cityName);
}
