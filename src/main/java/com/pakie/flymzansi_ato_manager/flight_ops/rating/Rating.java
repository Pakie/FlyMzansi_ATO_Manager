package com.pakie.flymzansi_ato_manager.flight_ops.rating;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.school_ops.instructor.Instructor;
import com.pakie.flymzansi_ato_manager.flight_ops.pilot.Pilot;
import com.pakie.flymzansi_ato_manager.school_ops.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rating")
public class Rating extends CommonObject {

    @ManyToMany(mappedBy = "ratings")
    List<Student> students;
    @ManyToMany(mappedBy = "ratings")
    List<Instructor> instructors;
    @ManyToMany(mappedBy = "ratings")
    List<Pilot> pilots;

    public Rating(String title, String description, String details, List<Student> students, List<Instructor> instructors, List<Pilot> pilots) {
        super(title, description, details);
        this.students = students;
        this.instructors = instructors;
        this.pilots = pilots;
    }

    public Rating() {

    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }
}
