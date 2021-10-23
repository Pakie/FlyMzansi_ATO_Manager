package com.pakie.flymzansi_ato_manager.common_objects.briefing;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.person.instructor.Instructor;

import javax.persistence.*;

@Entity
@Table(name = "briefing")
public class Briefing extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double pricePerHour;

    public Briefing(String title, String description, String details, Double pricePerHour) {
        super(title, description, details);
        this.pricePerHour = pricePerHour;
    }

    public Briefing() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
