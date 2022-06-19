package com.ritwik.movieBookingSystem;

import com.ritwik.movieBookingSystem.dao.*;
import com.ritwik.movieBookingSystem.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
public class MovieBookingSystemApplication {
	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

//		CarDao carDao = ctx.getBean(CarDao.class);
//		EngineDao engineDao = ctx.getBean((EngineDao.class));
//
//		Car car = new Car();
//		Engine engine = new Engine();
//
//		engine.setEngineName("super engine");
//		engine.setEngineId(45122);
//
//		Engine savedEngine = engineDao.save(engine);
//
//		System.out.println(savedEngine);
//
//		car.setCarName("super car");
//		car.setEngine(engine);
//		car.setCarId(2000);
//
//		Car savedCar = carDao.save(car);
//
//		System.out.println(savedCar);

		TheatreDao theatreDao = ctx.getBean(TheatreDao.class);
		MovieDao movieDao = ctx.getBean(MovieDao.class);

		Movie movie1 = new Movie();
		movie1.setMovieName("infinity war");
		movie1.setDuration(200);
		movie1.setMovieDescription("nice movie");
		movie1.setReleaseDate(LocalDateTime.of(2022, 5, 23, 7, 30));
		movie1.setTrailerUrl("trailer-url");
		movie1.setCoverPhotoUrl("cover-photo-url");
		movieDao.save(movie1);

		Movie movie2 = new Movie();
		movie2.setMovieName("endgame");
		movie2.setDuration(250);
		movie2.setMovieDescription("very nice movie");
		movie2.setReleaseDate(LocalDateTime.of(2022, 6, 2, 10, 30));
		movie2.setTrailerUrl("trailer-url");
		movie2.setCoverPhotoUrl("cover-photo-url");
		movieDao.save(movie2);

		Movie movie3 = new Movie();
		movie3.setMovieName("ultron");
		movie3.setDuration(300);
		movie3.setMovieDescription("very very nice movie");
		movie3.setReleaseDate(LocalDateTime.of(2022, 5, 20, 5, 30));
		movie3.setTrailerUrl("trailer-url");
		movie3.setCoverPhotoUrl("cover-photo-url");
		movieDao.save(movie3);

		Theatre theatre = new Theatre();
		theatre.setTheatreName("pvr");
		theatre.setTicketPrice(500);

		List<Movie> list = new ArrayList<>();

		list.add(movie1);
		list.add(movie2);
		list.add(movie3);

		theatre.setMovies(list);

		City city = new City();
		city.setCityName("ranchi");

		CityDao cityDao = ctx.getBean(CityDao.class);

		cityDao.save(city);

		theatre.setCity(city);
		theatreDao.save(theatre);


	}
}
