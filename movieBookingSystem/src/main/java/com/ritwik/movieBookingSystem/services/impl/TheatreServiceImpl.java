package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.daos.TheatreDao;
import com.ritwik.movieBookingSystem.entities.Movie;
import com.ritwik.movieBookingSystem.entities.Theatre;
import com.ritwik.movieBookingSystem.exceptions.NoTheatreContainingThisStringException;
import com.ritwik.movieBookingSystem.exceptions.NoTheatreFoundAtThisPriceException;
import com.ritwik.movieBookingSystem.exceptions.NoTheatreFoundWithTheGivenNameException;
import com.ritwik.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    private TheatreDao theatreDao;

    @Override
    public Theatre acceptTheatreDetails(Theatre theatre) {
        return theatreDao.save(theatre);
    }

    @Override
    public Theatre getTheatreDetails(int id) throws TheatreDetailsNotFoundException {
        return theatreDao.findById(id).orElseThrow(() -> new TheatreDetailsNotFoundException("theatre details not found for id: " + id));
    }

    @Override
    public List<Theatre> getTheatreDetailsBasedOnName(String theatreName) throws NoTheatreFoundWithTheGivenNameException {
        List<Theatre> foundTheatres = theatreDao.findByTheatreName(theatreName);
        if(foundTheatres.isEmpty()) {
            throw new NoTheatreFoundWithTheGivenNameException();
        }
        return foundTheatres;
    }

    @Override
    public List<Theatre> getTheatreDetailsWithTicketPriceLessThan(float ticketPrice) throws NoTheatreFoundAtThisPriceException {
        List<Theatre> foundTheatres = theatreDao.findByTicketPriceLessThan(ticketPrice);
        if(foundTheatres.isEmpty()) {
            throw new NoTheatreFoundAtThisPriceException();
        }
        return foundTheatres;
    }

    @Override
    public List<Theatre> getTheatreDetailsBasedOnNameContainingAString(String theatreName) throws NoTheatreContainingThisStringException {
        List<Theatre> foundTheatres = theatreDao.findByTheatreNameContaining(theatreName);
        if(foundTheatres.isEmpty()) {
            throw new NoTheatreContainingThisStringException();
        }
        return foundTheatres;
    }

    @Override
    public Theatre updateTheatreDetails(int id, Theatre theatre) throws TheatreDetailsNotFoundException {
        Theatre savedTheatre = getTheatreDetails(id);

        if(isNotNullOrZero(theatre.getTheatreName())) {
            savedTheatre.setTheatreName(theatre.getTheatreName());
        }

        if(isNotNullOrZero(theatre.getTicketPrice())) {
            savedTheatre.setTicketPrice(theatre.getTicketPrice());
        }

        if(isNotNullOrZero(theatre.getCity())) {
            savedTheatre.setCity(theatre.getCity());
        }

        return theatreDao.save(savedTheatre);
    }

    @Override
    public boolean deleteTheatre(int id) throws TheatreDetailsNotFoundException {
        Theatre savedTheatre = getTheatreDetails(id);
        theatreDao.delete(savedTheatre);
        return true;
    }

    @Override
    public List<Theatre> getAllTheatreDetails() {
        return theatreDao.findAll();
    }

    @Override
    public List<Movie> getListOfMoviesInATheatre(int theatreId) throws TheatreDetailsNotFoundException {
        Theatre foundTheatre = getTheatreDetails(theatreId);
        return foundTheatre.getMovies();
    }

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }

    private boolean isNotNullOrZero(float val) {
        return val >= 0.1f;
    }

}
