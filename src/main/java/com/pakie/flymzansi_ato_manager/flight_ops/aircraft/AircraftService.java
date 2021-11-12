package com.pakie.flymzansi_ato_manager.flight_ops.aircraft;

import java.util.List;

public interface AircraftService {
    List<Aircraft> getAllAircrafts();
    void saveAircraft(Aircraft aircraft);
    Aircraft getAircraftById(Long Id);
    void deleteAircraftById(Long Id);
}
