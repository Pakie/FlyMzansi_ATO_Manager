package com.pakie.flymzansi_ato_manager.school_ops.sponsor;

import java.util.List;

public interface SponsorService {
    List<Sponsor> getAllSponsors();
    void saveSponsor(Sponsor sponsor);
    Sponsor getSponsorById(Long Id);
    void deleteSponsorById(Long Id);
}
