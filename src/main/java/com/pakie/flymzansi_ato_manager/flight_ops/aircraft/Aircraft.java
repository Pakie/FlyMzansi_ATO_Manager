package com.pakie.flymzansi_ato_manager.flight_ops.aircraft;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.flight_ops.aircraft_type.AircraftType;

import javax.persistence.*;

@Entity
@Table(name = "aircraft")
public class Aircraft extends CommonObject {

    private String registration;
    private String colour;
    @ManyToOne(fetch = FetchType.EAGER)
    private AircraftType aircraftType;
    private Long tachometer;

    public Aircraft(String title, String description, String details, String registration, String colour, AircraftType aircraftType, Long tachometer) {
        super(title, description, details);
        this.registration = registration;
        this.colour = colour;
        this.aircraftType = aircraftType;
        this.tachometer = tachometer;
    }

    public Aircraft() {

    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(AircraftType aircraftType) {
        this.aircraftType = aircraftType;
    }

    public Long getTachometer() {
        return tachometer;
    }

    public void setTachometer(Long tachometer) {
        this.tachometer = tachometer;
    }
}
