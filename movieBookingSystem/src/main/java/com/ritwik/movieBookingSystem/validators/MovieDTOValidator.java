package com.ritwik.movieBookingSystem.validators;

import com.ritwik.movieBookingSystem.dtos.MovieDTO;
import com.ritwik.movieBookingSystem.exceptions.InvalidMovieNameException;
import org.springframework.stereotype.Component;

@Component
public class MovieDTOValidator {

    public void validate(MovieDTO movieDTO) throws InvalidMovieNameException {

        if(movieDTO.getMovieName() == null || movieDTO.getMovieName().equals("")) {
            throw new InvalidMovieNameException();
        }
    }

}
