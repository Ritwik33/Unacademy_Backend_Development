package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.dao.LanguageDao;
import com.ritwik.movieBookingSystem.entities.Language;
import com.ritwik.movieBookingSystem.exceptions.LanguageDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageDao languageDao;

    @Override
    public Language acceptLanguageDetails(Language language) {
        return languageDao.save(language);
    }

    @Override
    public Language getLanguageDetails(int id) throws LanguageDetailsNotFoundException {
        return languageDao.findById(id).orElseThrow(() -> new LanguageDetailsNotFoundException("Language not found for id: " + id));
    }

    @Override
    public Language getLanguageDetailsByLanguageName(String languageName) throws LanguageDetailsNotFoundException {
        return languageDao.findByLanguageName(languageName).orElseThrow(() -> new LanguageDetailsNotFoundException("language not found by language name: " + languageName));
    }

    @Override
    public boolean deleteLanguage(int id) throws LanguageDetailsNotFoundException {
        Language language = getLanguageDetails(id);
        languageDao.delete(language);
        return true;
    }

    @Override
    public List<Language> getAllLanguageDetails() {
        return languageDao.findAll();
    }
}
