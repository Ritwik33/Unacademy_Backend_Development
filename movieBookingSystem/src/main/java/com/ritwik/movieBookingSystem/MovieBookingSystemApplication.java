package com.ritwik.movieBookingSystem;

import com.ritwik.movieBookingSystem.dao.*;
import com.ritwik.movieBookingSystem.entities.*;
import com.ritwik.movieBookingSystem.exceptions.MovieDetailNotFoundException;
import com.ritwik.movieBookingSystem.services.MovieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.Set;

@SpringBootApplication
public class MovieBookingSystemApplication {
	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

	}
}
