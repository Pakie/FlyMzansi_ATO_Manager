package com.pakie.flymzansi_ato_manager.flight_ops.aircraft_maintenance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftMaintenanceServiceImpl implements AircraftMaintenanceService {
    @Autowired
    private AircraftMaintenanceRepo aircraftMaintenanceRepo;

    @Override
    public List<AircraftMaintenance> getAllAircraftMaintenances() {
        return aircraftMaintenanceRepo.findAll();
    }

    @Override
    public void saveAircraftMaintenance(AircraftMaintenance aircraftMaintenance) {
        this.aircraftMaintenanceRepo.save(aircraftMaintenance);
    }

    @Override
    public AircraftMaintenance getAircraftMaintenanceById(Long id) {
        Optional<AircraftMaintenance> optional = aircraftMaintenanceRepo.findById(id);
        AircraftMaintenance aircraftMaintenance = null;
        if (optional.isPresent()){
            aircraftMaintenance = optional.get();
        } else {
            throw new RuntimeException("The aircraftMaintenance with ID " + id + " does not exist");
        }
        return aircraftMaintenance;
    }

    @Override
    public void deleteAircraftMaintenanceById(Long id) {
        this.aircraftMaintenanceRepo.deleteById(id);
    }
}
