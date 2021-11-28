package com.pakie.flymzansi_ato_manager.school_ops.student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Long Id);
    void deleteStudentById(Long Id);
}
