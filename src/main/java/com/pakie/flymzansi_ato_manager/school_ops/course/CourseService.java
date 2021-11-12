package com.pakie.flymzansi_ato_manager.school_ops.course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    void saveCourse(Course course);
    Course getCourseById(Long Id);
    void deleteCourseById(Long Id);
}

