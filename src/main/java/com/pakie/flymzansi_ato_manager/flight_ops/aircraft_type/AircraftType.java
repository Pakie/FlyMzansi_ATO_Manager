package com.pakie.flymzansi_ato_manager.flight_ops.aircraft_type;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aircraft_type")
public class AircraftType extends CommonObject {

    @OneToMany(mappedBy = "aircraftType")
    List<Aircraft> aircrafts;

    public AircraftType(String title, String description, String details, List<Aircraft> aircrafts) {
        super(title, description, details);
        this.aircrafts = aircrafts;
    }

    public AircraftType() {

    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }
}
