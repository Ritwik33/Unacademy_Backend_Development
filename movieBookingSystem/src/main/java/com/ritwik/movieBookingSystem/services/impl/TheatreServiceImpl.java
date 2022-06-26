package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.dao.TheatreDao;
import com.ritwik.movieBookingSystem.entities.Theatre;
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

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }

    private boolean isNotNullOrZero(float val) {
        return val >= 0.1f;
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

}