package com.ritwik.movieBookingSystem.services;

import com.ritwik.movieBookingSystem.entities.City;
import com.ritwik.movieBookingSystem.exceptions.CityDetailsNotFoundException;

import java.util.List;

public interface CityService {

    public City acceptCityDetails(City city);
    public List<City> acceptMultipleCityDetails(List<City> cities);
    public City updateCityDetails(int id, City city) throws CityDetailsNotFoundException;
    public City getCityDetails(int id) throws CityDetailsNotFoundException;
    public City getCityDetailsByCityName(String cityName) throws CityDetailsNotFoundException;
    public boolean deleteCity(int id) throws CityDetailsNotFoundException;
    public List<City> getAllCityDetails();

}
