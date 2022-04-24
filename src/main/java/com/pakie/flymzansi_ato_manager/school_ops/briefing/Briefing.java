package com.pakie.flymzansi_ato_manager.school_ops.briefing;

import com.pakie.flymzansi_ato_manager.booking.Work;
import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.school_ops.instructor.Instructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "briefing")
public class Briefing extends Work {

    @ManyToOne
    private Instructor instructor;

    public Briefing() {

    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
