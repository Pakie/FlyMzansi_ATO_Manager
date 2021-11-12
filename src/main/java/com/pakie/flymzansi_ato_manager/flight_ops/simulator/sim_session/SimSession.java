package com.pakie.flymzansi_ato_manager.flight_ops.simulator.sim_session;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.flight_ops.simulator.Simulator;

import javax.persistence.*;

@Entity
@Table(name = "sim_session")
public class SimSession extends CommonObject {

    @ManyToOne(fetch = FetchType.EAGER)
    private Simulator simulator;

    public SimSession(String title, String description, String details, Simulator simulator) {
        super(title, description, details);
        this.simulator = simulator;
    }

    public SimSession() {

    }

    public Simulator getSimulator() {
        return simulator;
    }

    public void setSimulator(Simulator simulator) {
        this.simulator = simulator;
    }
}
