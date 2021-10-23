package com.pakie.flymzansi_ato_manager.common_objects.aircraft_type;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.common_objects.aircraft.Aircraft;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aircraft_type")
public class AircraftType extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "aircraftType")
    List<Aircraft> aircrafts;

    public AircraftType(String title, String description, String details, List<Aircraft> aircrafts) {
        super(title, description, details);
        this.aircrafts = aircrafts;
    }

    public AircraftType() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }
}
