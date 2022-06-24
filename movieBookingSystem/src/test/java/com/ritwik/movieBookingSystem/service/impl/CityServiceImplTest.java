package com.ritwik.movieBookingSystem.service.impl;

import com.ritwik.movieBookingSystem.dao.CityDao;
import com.ritwik.movieBookingSystem.entities.City;
import com.ritwik.movieBookingSystem.exceptions.CityDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.impl.CityServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CityServiceImplTest {

    /**
     * CityServiceImpl -> CityDao
     *
     * create mock of CityDao
     * create CityServiceImpl using mocked CityDao
     * provide the functionality of CityDao
     */

    @Mock
    private CityDao cityDao;

    @InjectMocks
    private CityServiceImpl cityService;

    @BeforeEach
    private void addFunctionalityToMockedCityDao() {
        Mockito.when(cityDao.save(new City("Bangalore"))).
                thenReturn(new City(1, "Bangalore"));

        /**
         * mock the function for get
         */

        Mockito.when(cityDao.findById(2)).
                thenReturn(Optional.of(new City(2, "Mumbai")));

        /**
         * mock the function for save
         */

        Mockito.when(cityDao.save(new City(2, "MumbaiNew"))).
                thenReturn(new City(2, "MumbaiNew"));

    }

    /**
     * acceptCityDetails
     */

    @Test
    public void acceptCityDetailsTest() {

        /**
         * test if CityServiceImpl is able to save City details
         */

        City city = new City("Bangalore");

        City savedCity = cityService.acceptCityDetails(city);

        Assertions.assertNotNull(savedCity);
        Assertions.assertEquals(1, savedCity.getCityId());
    }

    /**
     * acceptMultipleCityDetails
     */

    public void acceptMultipleCityDetailsTest() {

    }

    /**
     * updateCityDetails
     */

    @Test
    public void updateCityDetailsTest() throws CityDetailsNotFoundException {
        City city = new City("MumbaiNew");
        City updatedCity = cityService.updateCityDetails(2, city);

        Assertions.assertEquals(2, updatedCity.getCityId());
        Assertions.assertNotNull(updatedCity);
    }

    /**
     * getCityDetails
     */

    public void getCityDetailsTest() {

    }

    /**
     * getCityDetailsByCityName
     */

    public void getCityDetailsByCityNameTest() {

    }

    /**
     * deleteCity
     */

    public void deleteCityTest() {

    }

    /**
     * getAllCityDetails
     */

    public void getAllCityDetailsTest() {

    }

}
