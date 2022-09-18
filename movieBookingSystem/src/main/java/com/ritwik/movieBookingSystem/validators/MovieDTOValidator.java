package com.ritwik.movieBookingSystem.validators;

import com.ritwik.movieBookingSystem.dtos.MovieDTO;
import com.ritwik.movieBookingSystem.entities.Status;
import com.ritwik.movieBookingSystem.exceptions.*;
import com.ritwik.movieBookingSystem.services.impl.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieDTOValidator {

    @Autowired
    private StatusServiceImpl statusService;

    public void validate(MovieDTO movieDTO) throws
            InvalidMovieNameException,
            InvalidMovieDescriptionException,
            InvalidMovieDurationException,
            InvalidCoverPhotoUrlException,
            InvalidTrailerUrlException,
            InvalidReleaseDateException,
            InvalidStatusIdException {

        if(movieDTO.getMovieName() == null || movieDTO.getMovieName().equals("")) {
            throw new InvalidMovieNameException();
        }

        if(movieDTO.getMovieDescription() == null || movieDTO.getMovieDescription().equals("")) {
            throw new InvalidMovieDescriptionException();
        }

        if(movieDTO.getDuration() <= 0) {
            throw new InvalidMovieDurationException();
        }

        if(movieDTO.getCoverPhotoUrl() == null || movieDTO.getCoverPhotoUrl().equals("")) {
            throw new InvalidCoverPhotoUrlException();
        }

        if(movieDTO.getTrailerUrl() == null || movieDTO.getTrailerUrl().equals("")) {
            throw new InvalidTrailerUrlException();
        }

        if(movieDTO.getReleaseDate() == null) {
            throw new InvalidReleaseDateException();
        }

        List<Status> statuses = statusService.getAllStatusDetails();

        boolean flag = false;

        for(Status status : statuses) {
            if(status.getStatusId() == movieDTO.getStatusId()) {
                flag = true;
                break;
            }
        }

        if(!flag) {
            throw new InvalidStatusIdException();
        }
    }


}
