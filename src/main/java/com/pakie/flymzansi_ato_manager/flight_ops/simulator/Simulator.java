package com.pakie.flymzansi_ato_manager.flight_ops.simulator;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;

import javax.persistence.*;

@Entity
@Table(name = "simulator")
public class Simulator extends CommonObject {

    private String type;

    public Simulator(String title, String description, String details, String type) {
        super(title, description, details);
        this.type = type;
    }

    public Simulator() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
