package com.pakie.flymzansi_ato_manager.flight_ops.aircraft_maintenance;

import com.pakie.flymzansi_ato_manager.booking.Work;
import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;

import javax.persistence.*;

@Entity
@Table(name = "aircraft_maintenance")
public class AircraftMaintenance extends Work {

    @ManyToOne(fetch = FetchType.EAGER)
    private Aircraft aircraft;

    public AircraftMaintenance(String title, String description, double price, int duration, boolean editable, String targetCustomer, Aircraft aircraft) {
        super(title, description, price, duration, editable, targetCustomer);
        this.aircraft = aircraft;
    }

    public AircraftMaintenance() {

    }


    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
