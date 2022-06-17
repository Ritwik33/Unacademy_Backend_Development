package com.ritwik.movieBookingSystem.dao;

import com.ritwik.movieBookingSystem.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language, Integer> {

}
