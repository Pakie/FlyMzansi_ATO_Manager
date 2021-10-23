package com.pakie.flymzansi_ato_manager.common_objects.aircraft_type;

import java.util.List;

public interface AircraftTypeService {
    List<AircraftType> getAllAircraftTypes();
    void saveAircraftType(AircraftType aircraftType);
    AircraftType getAircraftTypeById(Long Id);
    void deleteAircraftTypeById(Long Id);
}
