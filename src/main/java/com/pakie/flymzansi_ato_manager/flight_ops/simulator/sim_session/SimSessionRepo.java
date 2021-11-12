package com.pakie.flymzansi_ato_manager.flight_ops.simulator.sim_session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimSessionRepo extends JpaRepository<SimSession, Long> {

}
