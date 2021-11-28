package com.pakie.flymzansi_ato_manager.flight_ops.pilot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotServiceImpl implements PilotService {
    @Autowired
    private PilotRepo pilotRepo;

    @Override
    public List<Pilot> getAllPilots() {
        return pilotRepo.findAll();
    }

    @Override
    public Pilot savePilot(Pilot pilot) {
        this.pilotRepo.save(pilot);
        return pilot;
    }

    @Override
    public Pilot getPilotById(Long id) {
        Optional<Pilot> optional = pilotRepo.findById(id);
        Pilot pilot = null;
        if (optional.isPresent()){
            pilot = optional.get();
        } else {
            throw new RuntimeException("The pilot with ID " + id + " does not exist");
        }
        return pilot;
    }

    @Override
    public void deletePilotById(Long id) {
        this.pilotRepo.deleteById(id);
    }
}
