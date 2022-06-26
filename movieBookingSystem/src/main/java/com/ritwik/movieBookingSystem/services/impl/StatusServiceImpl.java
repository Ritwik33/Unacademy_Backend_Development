package com.ritwik.movieBookingSystem.services.impl;

import com.ritwik.movieBookingSystem.dao.StatusDao;
import com.ritwik.movieBookingSystem.entities.Status;
import com.ritwik.movieBookingSystem.exceptions.StatusDetailsNotFoundException;
import com.ritwik.movieBookingSystem.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusDao statusDao;

    @Override
    public Status acceptStatusDetails(Status status) {
        return statusDao.save(status);
    }

    @Override
    public Status getStatusDetails(int id) throws StatusDetailsNotFoundException {
        return statusDao.findById(id).orElseThrow(() -> new StatusDetailsNotFoundException("Status not found for id: " + id));
    }

    @Override
    public Status getStatusDetailsByStatusName(String statusName) throws StatusDetailsNotFoundException {
        Status status = statusDao.findByStatusName(statusName);
        if(status == null) {
            throw new StatusDetailsNotFoundException("status not found by statusName: " + statusName);
        }
        return status;
    }

    @Override
    public boolean deleteStatus(int id) throws StatusDetailsNotFoundException {
        Status status = getStatusDetails(id);
        statusDao.delete(status);
        return true;
    }

    @Override
    public List<Status> getAllStatusDetails() {
        return statusDao.findAll();
    }
}