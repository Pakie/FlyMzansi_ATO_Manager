package com.pakie.flymzansi_ato_manager.school_ops.student;

import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    File upload(MultipartFile imageFile, Student student) throws IOException;
    boolean resizeImage(File sourceFile, Student student);
    Student getStudentById(Long Id);
    void deleteStudentById(Long Id);
}
