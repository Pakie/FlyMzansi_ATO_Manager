package com.pakie.flymzansi_ato_manager.school_ops.course;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.school_ops.subject.Subject;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course extends CommonObject {

    @OneToMany(mappedBy = "course")
    Set<Subject> subjects;

    public Course(String title, String description, String details, Set<Subject> subjects) {
        super(title, description, details);
        this.subjects = subjects;
    }

    public Course() {

    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}