package com.pakie.flymzansi_ato_manager.flight_ops.aircraft_maintenance;

import java.util.List;

public interface AircraftMaintenanceService {
    List<AircraftMaintenance> getAllAircraftMaintenances();
    void saveAircraftMaintenance(AircraftMaintenance aircraftMaintenance);
    AircraftMaintenance getAircraftMaintenanceById(Long Id);
    void deleteAircraftMaintenanceById(Long Id);
}
