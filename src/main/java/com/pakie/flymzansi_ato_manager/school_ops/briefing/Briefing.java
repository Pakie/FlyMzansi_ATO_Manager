package com.pakie.flymzansi_ato_manager.school_ops.briefing;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;

import javax.persistence.*;

@Entity
@Table(name = "briefing")
public class Briefing extends CommonObject {

    private Double pricePerHour;

    public Briefing(String title, String description, String details, Double pricePerHour) {
        super(title, description, details);
        this.pricePerHour = pricePerHour;
    }

    public Briefing() {

    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
