package com.pakie.flymzansi_ato_manager.school_ops.instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors();
    Instructor saveInstructor(Instructor instructor);
    Instructor getInstructorById(Long Id);
    void deleteInstructorById(Long Id);
}
