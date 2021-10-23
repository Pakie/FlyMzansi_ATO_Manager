package com.pakie.flymzansi_ato_manager.common_objects.aircraft;

import java.util.List;

public interface AircraftService {
    List<Aircraft> getAllAircrafts();
    void saveAircraft(Aircraft aircraft);
    Aircraft getAircraftById(Long Id);
    void deleteAircraftById(Long Id);
}
