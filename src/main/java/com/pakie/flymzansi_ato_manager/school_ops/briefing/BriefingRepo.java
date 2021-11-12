package com.pakie.flymzansi_ato_manager.school_ops.briefing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefingRepo extends JpaRepository<Briefing, Long> {

}
