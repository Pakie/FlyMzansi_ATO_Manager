package com.pakie.flymzansi_ato_manager.flight_ops.flight;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight extends CommonObject {

    @ManyToOne(fetch = FetchType.EAGER)
    private Aircraft aircraft;
    private Double price;

    public Flight(String title, String description, String details, Aircraft aircraft, Double price) {
        super(title, description, details);
        this.aircraft = aircraft;
        this.price = price;
    }

    public Flight() {

    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
