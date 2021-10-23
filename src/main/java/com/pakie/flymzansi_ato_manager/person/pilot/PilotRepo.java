package com.pakie.flymzansi_ato_manager.person.pilot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotRepo extends JpaRepository<Pilot, Long> {

}
