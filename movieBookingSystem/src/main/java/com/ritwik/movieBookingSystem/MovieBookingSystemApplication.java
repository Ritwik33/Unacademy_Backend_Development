package com.ritwik.movieBookingSystem;

import com.ritwik.movieBookingSystem.dao.MovieDao;
import com.ritwik.movieBookingSystem.entities.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MovieBookingSystemApplication {
	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

		MovieDao movieDao = ctx.getBean(MovieDao.class);

		/**
		 * --- creating movie object ---
		 */

		Movie movie = new Movie();
		movie.setMovieName("keshari");
		movie.setMovieDescription("very nice movie");
		movie.setReleaseDate(LocalDateTime.of(2019, 4, 27, 5, 30));
		movie.setDuration(150);
		movie.setCoverPhotoUrl("cover-photo-url");
		movie.setTrailerUrl("trailer-url");

		/**
		 * saving to DB
		 */

		Movie savedObject = movieDao.save(movie);

		Movie movie1 = new Movie();
		movie1.setMovieName("doctor strange in the multiverse of madness");
		movie1.setMovieDescription("wanda chudail ki bacchi, isse bach ke rehna");
		movie1.setReleaseDate(LocalDateTime.of(2022, 6, 27, 10, 30));
		movie1.setDuration(200);
		movie1.setCoverPhotoUrl("cover-photo-url");
		movie1.setTrailerUrl("trailer-url");

		Movie savedObject1 = movieDao.save(movie1);

		/**
		 * i should be able to find the movie i am interested in ...
		 */

		Movie searchedMovie = movieDao.findById(2).get();
		System.out.println("Searched movie : " + searchedMovie);

		/**
		 * update operation / updation
		 */

		movie.setMovieDescription("updated description");
		movieDao.save(movie);

		/**
		 * delete operation
		 */

		movieDao.delete(searchedMovie);

		Movie movie2 = new Movie();
		movie2.setMovieId(4); // whether we provide or not it doesn't care ...
		movie2.setMovieName("endgame");
		movie2.setMovieDescription("garda movie");
		movie2.setReleaseDate(LocalDateTime.of(2020, 5, 25, 6, 45));
		movie2.setDuration(300);
		movie2.setCoverPhotoUrl("cover-photo-url");
		movie2.setTrailerUrl("trailer-url");

		Movie savedObject2 = movieDao.save(movie2);

		List<Movie> result = movieDao.findByDurationGreaterThanEqual(150);
		System.out.println("result : " + result);
	}
}
