package com.vishwa.caching.redis.service;

import com.vishwa.caching.redis.dao.UserDao;
import com.vishwa.caching.redis.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


  @Autowired
  UserDao _userDao ;

  public User getUserDetails(Long id) throws InterruptedException {

    Thread.sleep(10000);
    return _userDao.findById(id).get();

  }

}
