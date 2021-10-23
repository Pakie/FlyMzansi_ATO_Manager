package com.pakie.flymzansi_ato_manager.common_objects.course;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.common_objects.subject.Subject;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "course")
    Set<Subject> subjects;

    public Course(String title, String description, String details, Set<Subject> subjects) {
        super(title, description, details);
        this.subjects = subjects;
    }

    public Course() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}