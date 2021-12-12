package com.pakie.flymzansi_ato_manager.school_ops.instructor;

import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors();
    Instructor saveInstructor(Instructor instructor);
    File upload(MultipartFile imageFile, Instructor instructor) throws IOException;
    boolean resizeImage(File sourceFile, Instructor instructor);
    Instructor getInstructorById(Long Id);
    void deleteInstructorById(Long Id);
}
