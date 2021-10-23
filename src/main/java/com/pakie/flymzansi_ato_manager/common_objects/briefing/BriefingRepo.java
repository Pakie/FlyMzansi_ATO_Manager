package com.pakie.flymzansi_ato_manager.common_objects.briefing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefingRepo extends JpaRepository<Briefing, Long> {

}
