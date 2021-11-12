package com.pakie.flymzansi_ato_manager.school_ops.ground_school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroundSchoolServiceImpl implements GroundSchoolService {
    @Autowired
    private GroundSchoolRepo groundSchoolRepo;

    @Override
    public List<GroundSchool> getAllGroundSchools() {
        return groundSchoolRepo.findAll();
    }

    @Override
    public void saveGroundSchool(GroundSchool groundSchool) {
        this.groundSchoolRepo.save(groundSchool);
    }

    @Override
    public GroundSchool getGroundSchoolById(Long id) {
        Optional<GroundSchool> optional = groundSchoolRepo.findById(id);
        GroundSchool groundSchool = null;
        if (optional.isPresent()){
            groundSchool = optional.get();
        } else {
            throw new RuntimeException("The groundSchool with ID " + id + " does not exist");
        }
        return groundSchool;
    }

    @Override
    public void deleteGroundSchoolById(Long id) {
        this.groundSchoolRepo.deleteById(id);
    }
}
