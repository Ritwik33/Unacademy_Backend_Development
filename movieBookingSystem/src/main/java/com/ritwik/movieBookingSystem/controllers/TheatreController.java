package com.ritwik.movieBookingSystem.controllers;

import com.ritwik.movieBookingSystem.dtos.MovieDTO;
import com.ritwik.movieBookingSystem.dtos.TheatreDTO;
import com.ritwik.movieBookingSystem.entities.Movie;
import com.ritwik.movieBookingSystem.entities.Theatre;
import com.ritwik.movieBookingSystem.exceptions.NoTheatreContainingThisStringException;
import com.ritwik.movieBookingSystem.exceptions.NoTheatreFoundAtThisPriceException;
import com.ritwik.movieBookingSystem.exceptions.NoTheatreFoundWithTheGivenNameException;
import com.ritwik.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.impl.TheatreServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/theatres")
public class TheatreController {

    @Autowired
    private TheatreServiceImpl theatreService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TheatreDTO> acceptTheatreDetails(@RequestBody TheatreDTO theatreDTO) {
        Theatre theatreToBeSaved = convertTheatreDTOToTheatre(theatreDTO);
        Theatre savedTheatre = theatreService.acceptTheatreDetails(theatreToBeSaved);
        TheatreDTO responseBody = convertTheatreToTheatreDTO(savedTheatre);
        return new ResponseEntity<TheatreDTO>(responseBody, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{theatreId}")
    public ResponseEntity<TheatreDTO> getTheatreDetailsBasedOnId(@PathVariable(value = "theatreId") int theatreId)
            throws TheatreDetailsNotFoundException {
        Theatre foundTheatre = theatreService.getTheatreDetails(theatreId);
        TheatreDTO responseBody = convertTheatreToTheatreDTO(foundTheatre);
        return new ResponseEntity<TheatreDTO>(responseBody, HttpStatus.OK);
    }

    @GetMapping(value = "/theatreName/{theatreName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TheatreDTO>> getTheatreDetailsBasedOnTheatreName(@PathVariable(value = "theatreName") String theatreName)
            throws NoTheatreFoundWithTheGivenNameException {
        List<Theatre> foundTheatres = theatreService.getTheatreDetailsBasedOnName(theatreName);
        List<TheatreDTO> responseBody = new ArrayList<>();
        foundTheatres.forEach(theatre -> responseBody.add(convertTheatreToTheatreDTO(theatre)));
        return new ResponseEntity<List<TheatreDTO>>(responseBody, HttpStatus.OK);
    }

    @GetMapping(value = "/ticketPriceLessThan/{ticketPrice}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TheatreDTO>> getTheatreDetailsBasedOnTicketPriceLessThan(@PathVariable(value = "ticketPrice") float ticketPrice)
            throws NoTheatreFoundAtThisPriceException {
        List<Theatre> foundTheatres = theatreService.getTheatreDetailsWithTicketPriceLessThan(ticketPrice);
        List<TheatreDTO> responseBody = new ArrayList<>();
        foundTheatres.forEach(theatre -> responseBody.add(convertTheatreToTheatreDTO(theatre)));
        return new ResponseEntity<List<TheatreDTO>>(responseBody, HttpStatus.OK);
    }

    @GetMapping(value = "/theatreNameContaining/{theatreName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TheatreDTO>> getTheatreDetailsBasedOnNameContainingAString(@PathVariable(value = "theatreName") String theatreName)
            throws NoTheatreContainingThisStringException {
        List<Theatre> foundTheatres = theatreService.getTheatreDetailsBasedOnNameContainingAString(theatreName);
        List<TheatreDTO> responseBody = new ArrayList<>();
        foundTheatres.forEach(theatre -> responseBody.add(convertTheatreToTheatreDTO(theatre)));
        return new ResponseEntity<List<TheatreDTO>>(responseBody, HttpStatus.OK);
    }

    @PutMapping(value = "/{theatreId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TheatreDTO> updateTheatreDetails(@PathVariable(value = "theatreId") int theatreId, @RequestBody TheatreDTO theatreDTO)
            throws TheatreDetailsNotFoundException {
        Theatre theatreUpdater = convertTheatreDTOToTheatre(theatreDTO);
        Theatre updatedTheatre = theatreService.updateTheatreDetails(theatreId, theatreUpdater);
        TheatreDTO responseBody = convertTheatreToTheatreDTO(updatedTheatre);
        return new ResponseEntity<TheatreDTO>(responseBody, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "{theatreId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteTheatre(@PathVariable(value = "theatreId") int theatreId)
            throws TheatreDetailsNotFoundException {
        theatreService.deleteTheatre(theatreId);
        return new ResponseEntity<String>("Theatre with the given ID deleted", HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TheatreDTO>> getAllTheatreDetails() {
        List<Theatre> foundTheatres = theatreService.getAllTheatreDetails();
        List<TheatreDTO> responseBody = new ArrayList<>();
        foundTheatres.forEach(theatre -> responseBody.add(convertTheatreToTheatreDTO(theatre)));
        return new ResponseEntity<List<TheatreDTO>>(responseBody, HttpStatus.OK);
    }

    @GetMapping(value = "/{theatreId}/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MovieDTO>> getListOfMoviesInATheatre(@PathVariable(value = "theatreId") int theatreId)
            throws TheatreDetailsNotFoundException {
        List<Movie> runningMovies = theatreService.getListOfMoviesInATheatre(theatreId);
        List<MovieDTO> responseBody = new ArrayList<>();
        runningMovies.forEach(movie -> responseBody.add(modelMapper.map(movie, MovieDTO.class)));
        return new ResponseEntity<List<MovieDTO>>(responseBody, HttpStatus.OK);
    }

    private TheatreDTO convertTheatreToTheatreDTO(Theatre theatre) {
        return modelMapper.map(theatre, TheatreDTO.class);
    }

    private Theatre convertTheatreDTOToTheatre(TheatreDTO theatreDTO) {
        return modelMapper.map(theatreDTO, Theatre.class);
    }
}
