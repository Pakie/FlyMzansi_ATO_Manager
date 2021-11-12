package com.pakie.flymzansi_ato_manager.flight_ops.aircraft_maintenance;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;

import javax.persistence.*;

@Entity
@Table(name = "aircraft_maintenance")
public class AircraftMaintenance extends CommonObject {

    @ManyToOne(fetch = FetchType.EAGER)
    private Aircraft aircraft;

    public AircraftMaintenance(String title, String description, String details, Aircraft aircraft) {
        super(title, description, details);
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
