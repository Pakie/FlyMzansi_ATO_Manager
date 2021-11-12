package com.pakie.flymzansi_ato_manager.school_ops.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        this.courseRepo.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        Optional<Course> optional = courseRepo.findById(id);
        Course course = null;
        if (optional.isPresent()){
            course = optional.get();
        } else {
            throw new RuntimeException("The course with ID " + id + " does not exist");
        }
        return course;
    }

    @Override
    public void deleteCourseById(Long id) {
        this.courseRepo.deleteById(id);
    }
}
