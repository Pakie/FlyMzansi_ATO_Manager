package com.pakie.flymzansi_ato_manager.school_ops.instructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    private InstructorRepo instructorRepo;

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepo.findAll();
    }

    @Override
    public void saveInstructor(Instructor instructor) {
        this.instructorRepo.save(instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        Optional<Instructor> optional = instructorRepo.findById(id);
        Instructor instructor = null;
        if (optional.isPresent()){
            instructor = optional.get();
        } else {
            throw new RuntimeException("The instructor with ID " + id + " does not exist");
        }
        return instructor;
    }

    @Override
    public void deleteInstructorById(Long id) {
        this.instructorRepo.deleteById(id);
    }
}
