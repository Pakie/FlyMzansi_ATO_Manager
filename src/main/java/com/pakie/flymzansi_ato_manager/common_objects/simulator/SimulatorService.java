package com.pakie.flymzansi_ato_manager.common_objects.simulator;

import java.util.List;

public interface SimulatorService {
    List<Simulator> getAllSimulators();
    void saveSimulator(Simulator simulator);
    Simulator getSimulatorById(Long Id);
    void deleteSimulatorById(Long Id);
}
