package com.vishwa.caching.redis;

import com.vishwa.caching.redis.dao.UserDao;
import com.vishwa.caching.redis.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class RedisApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao ;
	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User shubham = new User("Shubham", 2000);
		User pankaj = new User("Pankaj", 29000);
		User lewis = new User("Lewis", 550);
		User akshay = new User("Akshay", 33000);

		userDao.save(shubham);
		userDao.save(pankaj);
		userDao.save(lewis);
		userDao.save(akshay);
		System.out.println(userDao.findAll());
	}
}
