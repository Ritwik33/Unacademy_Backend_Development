package com.vishwa.caching.redis.controller;

import com.vishwa.caching.redis.dao.UserDao;
import com.vishwa.caching.redis.entities.User;
import com.vishwa.caching.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

  @Autowired
  private UserService userService ;


  @Cacheable(value = "users", key = "#userId", unless = "#result.followers < 12000")
  @GetMapping(value = "/{userId}")
  public User getUser(@PathVariable String userId) throws InterruptedException {
    return userService.getUserDetails(Long.valueOf(userId));
  }


}
