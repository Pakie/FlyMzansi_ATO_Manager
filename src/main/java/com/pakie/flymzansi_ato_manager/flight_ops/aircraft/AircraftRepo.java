package com.pakie.flymzansi_ato_manager.flight_ops.aircraft;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepo extends JpaRepository<Aircraft, Long> {

}