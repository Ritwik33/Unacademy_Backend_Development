package com.ritwik.movieBookingSystem.controllers;

import com.ritwik.movieBookingSystem.dtos.StatusDTO;
import com.ritwik.movieBookingSystem.entities.Status;
import com.ritwik.movieBookingSystem.exceptions.StatusDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.impl.StatusServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/statuses")
public class StatusController {

    @Autowired
    private StatusServiceImpl statusService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatusDTO> acceptStatusDetails(@RequestBody StatusDTO statusDTO) {
        Status newStatus = convertStatusDTOToStatus(statusDTO);
        Status createdStatus = statusService.acceptStatusDetails(newStatus);
        StatusDTO responseBody = convertStatusToStatusDTO(createdStatus);
        return new ResponseEntity<StatusDTO>(responseBody, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{statusId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatusDTO> getStatusDetails(@PathVariable(value = "statusId") int statusId)
            throws StatusDetailsNotFoundException {
        Status foundStatus = statusService.getStatusDetails(statusId);
        StatusDTO responseBody = convertStatusToStatusDTO(foundStatus);
        return new ResponseEntity<StatusDTO>(responseBody, HttpStatus.OK);
    }

    @GetMapping(value = "/statusName/{statusName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatusDTO> getStatusDetailsByStatusName(@PathVariable(value = "statusName") String statusName)
            throws StatusDetailsNotFoundException {
        Status foundStatus = statusService.getStatusDetailsByStatusName(statusName);
        StatusDTO responseBody = convertStatusToStatusDTO(foundStatus);
        return new ResponseEntity<StatusDTO>(responseBody, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{statusId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteStatus(@PathVariable(value = "statusId") int statusId)
            throws StatusDetailsNotFoundException {
        statusService.deleteStatus(statusId);
        return new ResponseEntity<String>("status with the given status id deleted", HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StatusDTO>> getAllStatusDetails() {
        List<Status> foundStatuses = statusService.getAllStatusDetails();
        List<StatusDTO> responseBody = new ArrayList<>();
        foundStatuses.forEach(status -> responseBody.add(convertStatusToStatusDTO(status)));
        return new ResponseEntity<List<StatusDTO>>(responseBody, HttpStatus.OK);
    }

    private StatusDTO convertStatusToStatusDTO(Status status) {
        return modelMapper.map(status, StatusDTO.class);
    }

    private Status convertStatusDTOToStatus(StatusDTO statusDTO) {
        return modelMapper.map(statusDTO, Status.class);
    }
}
