package com.pakie.flymzansi_ato_manager.school_ops.sponsor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepo extends JpaRepository<Sponsor, Long> {

}
