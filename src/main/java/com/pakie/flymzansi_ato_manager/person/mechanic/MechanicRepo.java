package com.pakie.flymzansi_ato_manager.person.mechanic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicRepo extends JpaRepository<Mechanic, Long> {

}
