package com.pakie.flymzansi_ato_manager.flight_ops.simulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimulatorServiceImpl implements SimulatorService {
    @Autowired
    private SimulatorRepo simulatorRepo;

    @Override
    public List<Simulator> getAllSimulators() {
        return simulatorRepo.findAll();
    }

    @Override
    public void saveSimulator(Simulator simulator) {
        this.simulatorRepo.save(simulator);
    }

    @Override
    public Simulator getSimulatorById(Long id) {
        Optional<Simulator> optional = simulatorRepo.findById(id);
        Simulator simulator = null;
        if (optional.isPresent()){
            simulator = optional.get();
        } else {
            throw new RuntimeException("The simulator with ID " + id + " does not exist");
        }
        return simulator;
    }

    @Override
    public void deleteSimulatorById(Long id) {
        this.simulatorRepo.deleteById(id);
    }
}
