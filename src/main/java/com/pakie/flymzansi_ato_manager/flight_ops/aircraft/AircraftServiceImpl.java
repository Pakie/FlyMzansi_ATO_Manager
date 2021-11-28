package com.pakie.flymzansi_ato_manager.flight_ops.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftServiceImpl implements AircraftService{
    @Autowired
    private AircraftRepo aircraftRepo;

    @Override
    public List<Aircraft> getAllAircrafts() {
        return aircraftRepo.findAll();
    }

    @Override
    public Aircraft saveAircraft(Aircraft aircraft) {
        this.aircraftRepo.save(aircraft);
        return aircraft;
    }

    @Override
    public Aircraft getAircraftById(Long id) {
        Optional<Aircraft> optional = aircraftRepo.findById(id);
        Aircraft aircraft = null;
        if (optional.isPresent()){
            aircraft = optional.get();
        } else {
            throw new RuntimeException("The aircraft with ID " + id + " does not exist");
        }
        return aircraft;
    }

    @Override
    public void deleteAircraftById(Long id) {
        this.aircraftRepo.deleteById(id);
    }
}
