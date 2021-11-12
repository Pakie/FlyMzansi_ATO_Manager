package com.pakie.flymzansi_ato_manager.flight_ops.simulator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulatorRepo extends JpaRepository<Simulator, Long> {

}
