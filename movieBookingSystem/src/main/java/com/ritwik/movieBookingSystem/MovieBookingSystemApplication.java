package com.ritwik.movieBookingSystem;

import com.ritwik.movieBookingSystem.dao.CarDao;
import com.ritwik.movieBookingSystem.dao.EngineDao;
import com.ritwik.movieBookingSystem.dao.MovieDao;
import com.ritwik.movieBookingSystem.entities.Car;
import com.ritwik.movieBookingSystem.entities.Engine;
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

		CarDao carDao = ctx.getBean(CarDao.class);
		EngineDao engineDao = ctx.getBean((EngineDao.class));

		Car car = new Car();
		Engine engine = new Engine();

		engine.setEngineName("super engine");
		engine.setEngineId(45122);

		Engine savedEngine = engineDao.save(engine);

		System.out.println(savedEngine);

		car.setCarName("super car");
		car.setEngine(engine);
		car.setCarId(2000);

		Car savedCar = carDao.save(car);

		System.out.println(savedCar);
	}
}
