package com.pakie.flymzansi_ato_manager.common_objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusRepo statusRepo;

    @Override
    public List<Status> getAllStatuses() {
        return statusRepo.findAll();
    }

    @Override
    public void SaveStatus(Status status) {
        this.statusRepo.save(status);
    }

    @Override
    public Status getStatusById(Long id) {
        Optional<Status> optional = statusRepo.findById(id);
        Status status = null;
        if (optional.isPresent()) {
            status = optional.get();
        } else {
            throw new RuntimeException("The status with ID " + id + " was not found");
        }
        return status;
    }

    @Override
    public void deleteStatusById(Long id) {
        this.statusRepo.deleteById(id);
    }
}
