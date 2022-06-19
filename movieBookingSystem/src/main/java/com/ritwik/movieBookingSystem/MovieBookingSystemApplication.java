package com.ritwik.movieBookingSystem;

import com.ritwik.movieBookingSystem.dao.*;
import com.ritwik.movieBookingSystem.entities.*;
import com.ritwik.movieBookingSystem.exceptions.MovieDetailNotFoundException;
import com.ritwik.movieBookingSystem.services.MovieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class MovieBookingSystemApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

		MovieService movieService = ctx.getBean(MovieService.class);
		StatusDao statusDao = ctx.getBean(StatusDao.class);

		Status status = new Status();
		status.setStatusName("RELEASED");
		statusDao.save(status);

		Movie movie = new Movie();
		movie.setMovieDescription("good movie");
		movie.setMovieName("story of gold in olympics");
		movie.setCoverPhotoUrl("cover-photo-url");
		movie.setTrailerUrl("trailer-url");
		movie.setDuration(120);
		movie.setReleaseDate(LocalDateTime.of(2020, 1, 2, 4, 20));
		movie.setStatus(status);

		Movie storedMovie = movieService.acceptMovieDetails(movie);

		try {
			movieService.getMovieDetails(storedMovie.getMovieId());
		} catch (MovieDetailNotFoundException e) {
			e.printStackTrace();
		}


	}
}
