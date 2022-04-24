package com.pakie.flymzansi_ato_manager.flight_ops.flight;

import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;
import com.pakie.flymzansi_ato_manager.school_ops.instructor.Instructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="training_flight")
public class TrainingFlight extends Flight {
    @ManyToOne
    private Instructor instructor;

    public TrainingFlight(String title, String description, double price, int duration, boolean editable, String targetCustomer, Aircraft aircraft, Instructor instructor) {
        super(title, description, price, duration, editable, targetCustomer, aircraft);
        this.instructor = instructor;
    }

    public TrainingFlight() {

    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
