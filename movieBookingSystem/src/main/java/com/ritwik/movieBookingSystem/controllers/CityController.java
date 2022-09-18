package com.ritwik.movieBookingSystem.controllers;

import com.ritwik.movieBookingSystem.dtos.CityDTO;
import com.ritwik.movieBookingSystem.entities.City;
import com.ritwik.movieBookingSystem.exceptions.CityDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.impl.CityServiceImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    private CityServiceImpl cityService;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDTO> acceptCityDetails(@RequestBody CityDTO cityDTO) {

        City city = convertCityDTOToCity(cityDTO);
        City savedCity = cityService.acceptCityDetails(city);
        CityDTO responseBody = convertCityToCityDTO(savedCity);
        return new ResponseEntity<CityDTO>(responseBody, HttpStatus.CREATED);

    }

    @PostMapping(value = "/cityList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityDTO>> acceptMultipleCityDetails(@RequestBody List<CityDTO> cityDTOS) {

        List<City> citiesToBeSaved = new ArrayList<>();
        cityDTOS.forEach(cityDTO -> citiesToBeSaved.add(convertCityDTOToCity(cityDTO)));
        List<City> savedCities = cityService.acceptMultipleCityDetails(citiesToBeSaved);
        List<CityDTO> responseBody = new ArrayList<>();
        savedCities.forEach(savedCity -> responseBody.add(convertCityToCityDTO(savedCity)));
        return new ResponseEntity<List<CityDTO>>(responseBody, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{cityId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDTO> updateCityDetails(@PathVariable(value = "cityId") int cityId, @RequestBody CityDTO cityDTO)
            throws CityDetailsNotFoundException {
        City cityUpdater = convertCityDTOToCity(cityDTO);
        City updatedCity = cityService.updateCityDetails(cityId, cityUpdater);
        CityDTO responseBody = convertCityToCityDTO(updatedCity);
        return new ResponseEntity<CityDTO>(responseBody, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{cityId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDTO> getCityDetailsById(@PathVariable(value = "cityId") int cityId)
            throws CityDetailsNotFoundException {
        City foundCity = cityService.getCityDetails(cityId);
        CityDTO responseBody = convertCityToCityDTO(foundCity);
        return new ResponseEntity<CityDTO>(responseBody, HttpStatus.OK);
    }

    @GetMapping(value = "/cityName/{cityName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityDTO>> getCityDetailsByCityName(@PathVariable(value = "cityName") String cityName)
            throws CityDetailsNotFoundException {
        List<City> foundCities = cityService.getCityDetailsByCityName(cityName);
        List<CityDTO> responseBody = new ArrayList<>();
        foundCities.forEach(city -> responseBody.add(convertCityToCityDTO(city)));
        return new ResponseEntity<List<CityDTO>>(responseBody, HttpStatus.OK);
    }

    @DeleteMapping(value = "{cityId}")
    public ResponseEntity<String> deleteCity(@PathVariable(value = "cityId") int cityId)
            throws CityDetailsNotFoundException {
        cityService.deleteCity(cityId);
        return new ResponseEntity<String>("City with the given city id deleted", HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityDTO>> getAllCityDetails() {

        List<City> foundCities = cityService.getAllCityDetails();
        List<CityDTO> responseBody = new ArrayList<>();
        foundCities.forEach(foundCity -> responseBody.add(convertCityToCityDTO(foundCity)));
        return new ResponseEntity<List<CityDTO>>(responseBody, HttpStatus.OK);

    }

    private CityDTO convertCityToCityDTO(City city) {
        return modelMapper.map(city, CityDTO.class);
    }

    private City convertCityDTOToCity(CityDTO cityDTO) {
        return modelMapper.map(cityDTO, City.class);
    }
}
