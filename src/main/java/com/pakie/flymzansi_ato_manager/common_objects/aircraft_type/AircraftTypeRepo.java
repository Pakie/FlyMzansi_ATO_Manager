package com.pakie.flymzansi_ato_manager.common_objects.aircraft_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftTypeRepo extends JpaRepository<AircraftType, Long> {

}
