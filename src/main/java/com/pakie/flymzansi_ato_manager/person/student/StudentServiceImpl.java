package com.pakie.flymzansi_ato_manager.person.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo StudentRepo;

    @Override
    public List<Student> getAllStudents() {
        return StudentRepo.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.StudentRepo.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optional = StudentRepo.findById(id);
        Student student = null;
        if (optional.isPresent()){
            student = optional.get();
        } else {
            throw new RuntimeException("The Student with ID " + id + " does not exist");
        }
        return student;
    }

    @Override
    public void deleteStudentById(Long id) {
        this.StudentRepo.deleteById(id);
    }
}
