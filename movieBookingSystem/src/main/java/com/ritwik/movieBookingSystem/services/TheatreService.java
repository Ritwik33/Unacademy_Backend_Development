package com.ritwik.movieBookingSystem.services;

import com.ritwik.movieBookingSystem.entities.Movie;
import com.ritwik.movieBookingSystem.entities.Theatre;
import com.ritwik.movieBookingSystem.exceptions.NoTheatreContainingThisStringException;
import com.ritwik.movieBookingSystem.exceptions.NoTheatreFoundAtThisPriceException;
import com.ritwik.movieBookingSystem.exceptions.NoTheatreFoundWithTheGivenNameException;
import com.ritwik.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;

import java.util.List;

public interface TheatreService {
    public Theatre acceptTheatreDetails(Theatre theatre);
    public Theatre getTheatreDetails(int id) throws TheatreDetailsNotFoundException;
    public List<Theatre> getTheatreDetailsBasedOnName(String theatreName) throws NoTheatreFoundWithTheGivenNameException;
    public List<Theatre> getTheatreDetailsWithTicketPriceLessThan(float ticketPrice) throws NoTheatreFoundAtThisPriceException;
    public List<Theatre> getTheatreDetailsBasedOnNameContainingAString(String theatreName) throws NoTheatreContainingThisStringException;
    public Theatre updateTheatreDetails(int id, Theatre theatre) throws TheatreDetailsNotFoundException;
    public boolean deleteTheatre(int id) throws TheatreDetailsNotFoundException;
    public List<Theatre> getAllTheatreDetails();
    public List<Movie> getListOfMoviesInATheatre(int theatreId) throws TheatreDetailsNotFoundException;
}
