package com.pakie.flymzansi_ato_manager.common_objects.sim_session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimSessionRepo extends JpaRepository<SimSession, Long> {

}
