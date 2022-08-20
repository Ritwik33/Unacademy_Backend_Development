package com.vishwa.caching.redis.dao;

import com.vishwa.caching.redis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User, Long> {

}
