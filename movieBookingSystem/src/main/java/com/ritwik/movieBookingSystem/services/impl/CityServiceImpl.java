package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.daos.CityDao;
import com.ritwik.movieBookingSystem.entities.City;
import com.ritwik.movieBookingSystem.exceptions.CityDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public City acceptCityDetails(City city) {
        return cityDao.save(city);
    }

    @Override
    public List<City> acceptMultipleCityDetails(List<City> cities) {
        List<City> savedCities = new ArrayList<City>();
        for(City city : cities) {
            savedCities.add(acceptCityDetails(city));
        }
        return savedCities;
    }

    @Override
    public City updateCityDetails(int id, City city) throws CityDetailsNotFoundException {
        City savedCity = getCityDetails(id);
        savedCity.setCityName(city.getCityName());
        return acceptCityDetails(savedCity);
    }

    @Override
    public City getCityDetails(int id) throws CityDetailsNotFoundException {
        return cityDao.findById(id).orElseThrow(() -> new CityDetailsNotFoundException("city not found for id: " + id));
    }

    @Override
    public City getCityDetailsByCityName(String cityName) throws CityDetailsNotFoundException {
        City savedCity = cityDao.findByCityName(cityName);
        if(savedCity == null) {
            throw new CityDetailsNotFoundException("city not found for cityname: " + cityName);
        }
        return savedCity;
    }

    @Override
    public boolean deleteCity(int id) throws CityDetailsNotFoundException {
        City savedCity = getCityDetails(id);
        cityDao.delete(savedCity);
        return true;
    }

    @Override
    public List<City> getAllCityDetails() {
        return cityDao.findAll();
    }
}
