package com.pakie.flymzansi_ato_manager.flight_ops.flight;

import com.pakie.flymzansi_ato_manager.booking.Work;
import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;
import com.pakie.flymzansi_ato_manager.school_ops.instructor.Instructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "flight")
@Inheritance(strategy = InheritanceType.JOINED)
public class Flight extends Work {
    @ManyToOne
    private Aircraft aircraft;

    public Flight() {

    }

    public Flight(String title, String description, double price, int duration, boolean editable, String targetCustomer, Aircraft aircraft) {
        super(title, description, price, duration, editable, targetCustomer);
        this.aircraft = aircraft;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
