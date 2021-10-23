package com.pakie.flymzansi_ato_manager.common_objects.aircraft_maintenance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftMaintenanceRepo extends JpaRepository<AircraftMaintenance, Long> {

}
