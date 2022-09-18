package com.ritwik.movieBookingSystem.controllers;

import com.ritwik.movieBookingSystem.dtos.UserDTO;
import com.ritwik.movieBookingSystem.entities.Users;
import com.ritwik.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.ritwik.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.ritwik.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> acceptUserDetails(@RequestBody UserDTO userDTO)
            throws UserTypeDetailsNotFoundException, UserNameAlreadyExistsException {
        Users userToBeSaved = convertUserDTOToUser(userDTO);
        Users savedUser = userService.acceptUserDetails(userToBeSaved);
        UserDTO responseBody = convertUserToUserDTO(savedUser);
        return new ResponseEntity<UserDTO>(responseBody, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUserDetailsByUserId(@PathVariable(value = "userId") int userId)
            throws UserDetailsNotFoundException {
        Users foundUser = userService.getUserDetails(userId);
        UserDTO responseBody = convertUserToUserDTO(foundUser);
        return new ResponseEntity<UserDTO>(responseBody, HttpStatus.OK);
    }

    @GetMapping(value = "/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUserDetailsByUserName(@PathVariable(value = "username") String username)
            throws UserDetailsNotFoundException {
        Users foundUser = userService.getUserDetailsByUserName(username);
        UserDTO responseBody = convertUserToUserDTO(foundUser);
        return new ResponseEntity<UserDTO>(responseBody, HttpStatus.OK);
    }

    @PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUserDetails(@PathVariable(value = "userId") int userId, @RequestBody UserDTO userDTO)
            throws UserDetailsNotFoundException, UserTypeDetailsNotFoundException, UserNameAlreadyExistsException {
        Users userUpdater = convertUserDTOToUser(userDTO);
        Users updatedUser = userService.updateUserDetails(userId, userUpdater);
        UserDTO responseBody = convertUserToUserDTO(updatedUser);
        return new ResponseEntity<UserDTO>(responseBody, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteUser(@PathVariable(value = "userId") int userId)
            throws UserDetailsNotFoundException {
        userService.deleteUser(userId);
        return new ResponseEntity<String>("user with the user id deleted", HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUserDetails() {
        List<Users> foundUsers = userService.getAllUserDetails();
        List<UserDTO> responseBody = new ArrayList<>();
        foundUsers.forEach(users -> responseBody.add(convertUserToUserDTO(users)));
        return new ResponseEntity<List<UserDTO>>(responseBody, HttpStatus.OK);
    }

    private Users convertUserDTOToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, Users.class);
    }

    private UserDTO convertUserToUserDTO(Users user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
