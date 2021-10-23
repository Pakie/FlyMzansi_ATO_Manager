package com.pakie.flymzansi_ato_manager.common_objects.aircraft_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftTypeServiceImpl implements AircraftTypeService {
    @Autowired
    private AircraftTypeRepo aircraftTypeRepo;

    @Override
    public List<AircraftType> getAllAircraftTypes() {
        return aircraftTypeRepo.findAll();
    }

    @Override
    public void saveAircraftType(AircraftType aircraftType) {
        this.aircraftTypeRepo.save(aircraftType);
    }

    @Override
    public AircraftType getAircraftTypeById(Long id) {
        Optional<AircraftType> optional = aircraftTypeRepo.findById(id);
        AircraftType aircraftType = null;
        if (optional.isPresent()){
            aircraftType = optional.get();
        } else {
            throw new RuntimeException("The aircraftType with ID " + id + " does not exist");
        }
        return aircraftType;
    }

    @Override
    public void deleteAircraftTypeById(Long id) {
        this.aircraftTypeRepo.deleteById(id);
    }
}
