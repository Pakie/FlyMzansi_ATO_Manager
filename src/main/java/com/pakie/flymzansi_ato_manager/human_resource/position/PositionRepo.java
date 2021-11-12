package com.pakie.flymzansi_ato_manager.human_resource.position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends JpaRepository<Position, Long> {

}
