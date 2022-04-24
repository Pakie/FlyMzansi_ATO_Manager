package com.pakie.flymzansi_ato_manager.school_ops.subject;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.school_ops.course.Course;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject extends CommonObject {

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    public Subject(String title, String description, Course course) {
        super(title, description);
        this.course = course;
    }


    public Subject() {

    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
