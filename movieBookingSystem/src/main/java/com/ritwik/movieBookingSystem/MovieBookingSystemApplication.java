package com.ritwik.movieBookingSystem;

import com.ritwik.movieBookingSystem.entities.*;
import com.ritwik.movieBookingSystem.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MovieBookingSystemApplication {
	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);


	}

	/**
	 * This is a way to execute something in the very beginning when application is starting up ...
	 * @param initService
	 * @return
	 */

	@Bean
	CommandLineRunner init(InitService initService) {
		return args -> {
			initService.init();
		};
	}
}
