package com.ritwik.movieBookingSystem.controllers;

import com.ritwik.movieBookingSystem.dtos.UserTypeDTO;
import com.ritwik.movieBookingSystem.entities.UserType;
import com.ritwik.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.impl.UserTypeServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/userTypes")
public class UserTypeController {

    @Autowired
    private UserTypeServiceImpl userTypeService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserTypeDTO> acceptUserTypeDetails(@RequestBody UserTypeDTO userTypeDTO) {
        UserType newUserType = convertUserTypeDTOToUserType(userTypeDTO);
        UserType createdUserType = userTypeService.acceptUserTypeDetails(newUserType);
        UserTypeDTO responseBody = convertUserTypeToUserTypeDTO(createdUserType);
        return new ResponseEntity<UserTypeDTO>(responseBody, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{userTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserTypeDTO> getUserTypeDetails(@PathVariable(value = "userTypeId") int userTypeId)
            throws UserTypeDetailsNotFoundException {
        UserType foundUserType = userTypeService.getUserTypeDetails(userTypeId);
        UserTypeDTO responseBody = convertUserTypeToUserTypeDTO(foundUserType);
        return new ResponseEntity<UserTypeDTO>(responseBody, HttpStatus.OK);
    }

    @GetMapping(value = "/userTypeName/{userTypeName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserTypeDTO> getUserTypeDetailsByUserTypeName(@PathVariable(value = "userTypeName") String userTypeName)
            throws UserTypeDetailsNotFoundException {
        UserType foundUserType = userTypeService.getUserTypeDetailsByUserTypeName(userTypeName);
        UserTypeDTO responseBody = convertUserTypeToUserTypeDTO(foundUserType);
        return new ResponseEntity<UserTypeDTO>(responseBody, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{userTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteUserType(@PathVariable(value = "userTypeId") int userTypeId)
            throws UserTypeDetailsNotFoundException {
        userTypeService.deleteUserType(userTypeId);
        return new ResponseEntity<String>("user type with the given user type id deleted", HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserTypeDTO>> getAllUserTypeDetails() {
        List<UserType> foundUserTypes = userTypeService.getAllUserTypeDetails();
        List<UserTypeDTO> responseBody = new ArrayList<>();
        foundUserTypes.forEach(userType -> responseBody.add(convertUserTypeToUserTypeDTO(userType)));
        return new ResponseEntity<List<UserTypeDTO>>(responseBody, HttpStatus.OK);
    }

    private UserTypeDTO convertUserTypeToUserTypeDTO(UserType userType) {
        return modelMapper.map(userType, UserTypeDTO.class);
    }

    private UserType convertUserTypeDTOToUserType(UserTypeDTO userTypeDTO) {
        return modelMapper.map(userTypeDTO, UserType.class);
    }
}
