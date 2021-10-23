package com.pakie.flymzansi_ato_manager.common_objects.flight;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.common_objects.aircraft.Aircraft;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
