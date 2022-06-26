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

import java.util.Arrays;
import java.util.List;
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

        /**
         * mocking the acceptMultipleCitiesDetails method
         */

        Mockito.when(cityDao.save(new City(1, "ranchi"))).
                thenReturn(new City(1, "ranchi"));

        Mockito.when(cityDao.save(new City(2, "mumbai"))).
                thenReturn(new City(2, "mumbai"));

        Mockito.when(cityDao.save(new City(3, "delhi"))).
                thenReturn(new City(3, "delhi"));

        Mockito.when(cityDao.findByCityName("mumbai")).
                thenReturn(new City(1, "mumbai"));

        List<City> cities = Arrays.asList(
                new City(1, "mumbai"),
                new City(2, "delhi"),
                new City(3, "bangalore"),
                new City(4, "chandigarh")
        );

        Mockito.when(cityDao.findAll()).thenReturn(cities);

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

    @Test
    public void acceptMultipleCityDetailsTest() {

        List<City> cities = Arrays.asList(
                new City(1, "ranchi"),
                new City(2, "mumbai"),
                new City(3, "delhi"));

        List<City> savedCities = cityService.acceptMultipleCityDetails(cities);

        Assertions.assertNotNull(savedCities);
        savedCities.forEach(city -> Assertions.assertNotNull(city));
        Assertions.assertEquals(savedCities.size(), cities.size());
        for(int i = 0;i<savedCities.size();i++) {
            Assertions.assertEquals(cities.get(i).getCityId(), savedCities.get(i).getCityId());
        }
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

    @Test
    public void getCityDetailsTest() throws CityDetailsNotFoundException {
        City city = cityService.getCityDetails(2);
        Assertions.assertNotNull(city);
        Assertions.assertEquals("Mumbai", city.getCityName());
    }

    /**
     * getCityDetailsByCityName
     */

    @Test
    public void getCityDetailsByCityNameTest() throws CityDetailsNotFoundException {
        City city = cityService.getCityDetailsByCityName("mumbai");
        Assertions.assertNotNull(city);
        Assertions.assertEquals(1, city.getCityId());
    }

    /**
     * deleteCity
     */

    public void deleteCityTest() {

    }

    /**
     * getAllCityDetails
     */

    @Test
    public void getAllCityDetailsTest() {
        List<City> cities = cityService.getAllCityDetails();
        Assertions.assertNotNull(cities);
        cities.forEach(city -> Assertions.assertNotNull(city));
        cities.forEach(city -> System.out.println(city));
    }

}
