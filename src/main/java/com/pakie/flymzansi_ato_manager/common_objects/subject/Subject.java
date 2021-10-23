package com.pakie.flymzansi_ato_manager.common_objects.subject;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.common_objects.course.Course;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    public Subject(String title, String description, String details, Course course) {
        super(title, description, details);
        this.course = course;
    }


    public Subject() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
