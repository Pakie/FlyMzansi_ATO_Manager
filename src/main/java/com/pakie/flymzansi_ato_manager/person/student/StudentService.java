package com.pakie.flymzansi_ato_manager.person.student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void saveStudent(Student student);
    Student getStudentById(Long Id);
    void deleteStudentById(Long Id);
}
