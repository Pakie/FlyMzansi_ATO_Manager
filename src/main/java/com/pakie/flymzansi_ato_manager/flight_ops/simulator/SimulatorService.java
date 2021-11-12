package com.pakie.flymzansi_ato_manager.flight_ops.simulator;

import java.util.List;

public interface SimulatorService {
    List<Simulator> getAllSimulators();
    void saveSimulator(Simulator simulator);
    Simulator getSimulatorById(Long Id);
    void deleteSimulatorById(Long Id);
}
