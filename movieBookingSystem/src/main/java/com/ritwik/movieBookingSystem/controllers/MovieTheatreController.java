package com.ritwik.movieBookingSystem.controllers;

import com.ritwik.movieBookingSystem.dtos.MovieTheatreDTO;
import com.ritwik.movieBookingSystem.entities.MovieTheatre;
import com.ritwik.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.impl.MovieTheatreServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/movieTheatres")
public class MovieTheatreController {

    @Autowired
    private MovieTheatreServiceImpl movieTheatreService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieTheatreDTO> acceptMovieTheatreDetails(@RequestBody MovieTheatreDTO movieTheatreDTO)
            throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException {
        MovieTheatre newMovieTheatre = convertMovieTheatreDTOToMovieTheatre(movieTheatreDTO);
        MovieTheatre savedMovieTheatre = movieTheatreService.acceptMovieTheatreDetails(newMovieTheatre);
        MovieTheatreDTO responseBody = convertMovieTheatreToMovieTheatreDTO(savedMovieTheatre);
        return new ResponseEntity<MovieTheatreDTO>(responseBody, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{movieTheatreId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieTheatreDTO> getMovieTheatreDetails(@PathVariable(value = "movieTheatreId") int movieTheatreId)
            throws MovieTheatreDetailsNotFoundException {
        MovieTheatre foundMovieTheatre = movieTheatreService.getMovieTheatreDetails(movieTheatreId);
        MovieTheatreDTO responseBody = convertMovieTheatreToMovieTheatreDTO(foundMovieTheatre);
        return new ResponseEntity<MovieTheatreDTO>(responseBody, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{movieTheatreId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteMovieTheatre(@PathVariable(value = "movieTheatreId") int movieTheatreId)
            throws MovieTheatreDetailsNotFoundException {
        movieTheatreService.deleteMovieTheatre(movieTheatreId);
        return new ResponseEntity<String>("deleted movie theatre with given id", HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MovieTheatreDTO>> getAllMovieTheatreDetails() {
        List<MovieTheatre> movieTheatres = movieTheatreService.getAllMovieTheatreDetails();
        List<MovieTheatreDTO> responseBody = new ArrayList<>();
        movieTheatres.forEach(movieTheatre -> responseBody.add(convertMovieTheatreToMovieTheatreDTO(movieTheatre)));
        return new ResponseEntity<List<MovieTheatreDTO>>(responseBody, HttpStatus.OK);
    }

    private MovieTheatreDTO convertMovieTheatreToMovieTheatreDTO(MovieTheatre movieTheatre) {
        return modelMapper.map(movieTheatre, MovieTheatreDTO.class);
    }

    private MovieTheatre convertMovieTheatreDTOToMovieTheatre(MovieTheatreDTO movieTheatreDTO) {
        return modelMapper.map(movieTheatreDTO, MovieTheatre.class);
    }
}
