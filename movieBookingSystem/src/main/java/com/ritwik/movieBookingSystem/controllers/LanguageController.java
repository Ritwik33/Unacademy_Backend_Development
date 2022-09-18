package com.ritwik.movieBookingSystem.controllers;

import com.ritwik.movieBookingSystem.dtos.LanguageDTO;
import com.ritwik.movieBookingSystem.entities.Language;
import com.ritwik.movieBookingSystem.exceptions.LanguageDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.impl.LanguageServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/languages")
public class LanguageController {

    @Autowired
    private LanguageServiceImpl languageService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageDTO> acceptLanguageDetails(@RequestBody LanguageDTO languageDTO) {
        Language newLanguage = convertLanguageDTOToLanguage(languageDTO);
        Language createdLanguage = languageService.acceptLanguageDetails(newLanguage);
        LanguageDTO responseBody = convertLanguageToLanguageDTO(createdLanguage);
        return new ResponseEntity<LanguageDTO>(responseBody, HttpStatus.OK);
    }

    @GetMapping(value = "/{languageId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageDTO> getLanguageDetails(@PathVariable(value = "languageId") int languageId)
            throws LanguageDetailsNotFoundException {
        Language foundLanguage = languageService.getLanguageDetails(languageId);
        LanguageDTO responseBody = convertLanguageToLanguageDTO(foundLanguage);
        return new ResponseEntity<LanguageDTO>(responseBody, HttpStatus.OK);
    }

    @GetMapping(value = "/languageName/{languageName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageDTO> getLanguageDetailsByLanguageName(@PathVariable(value = "languageName") String languageName)
            throws LanguageDetailsNotFoundException {
        Language foundLanguage = languageService.getLanguageDetailsByLanguageName(languageName);
        LanguageDTO responseBody = convertLanguageToLanguageDTO(foundLanguage);
        return new ResponseEntity<LanguageDTO>(responseBody, HttpStatus.OK);
    }

    @DeleteMapping(value = "{languageId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteLanguage(@PathVariable(value = "languageId") int languageId)
            throws LanguageDetailsNotFoundException {
        languageService.deleteLanguage(languageId);
        return new ResponseEntity<String>("Language with the given id deleted", HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LanguageDTO>> getAllLanguageDetails() {
        List<Language> foundLanguages = languageService.getAllLanguageDetails();
        List<LanguageDTO> responseBody = new ArrayList<>();
        foundLanguages.forEach(language -> responseBody.add(convertLanguageToLanguageDTO(language)));
        return new ResponseEntity<List<LanguageDTO>>(responseBody, HttpStatus.OK);
    }

    private LanguageDTO convertLanguageToLanguageDTO(Language language) {
        return modelMapper.map(language, LanguageDTO.class);
    }

    private Language convertLanguageDTOToLanguage(LanguageDTO languageDTO) {
        return modelMapper.map(languageDTO, Language.class);
    }
}
