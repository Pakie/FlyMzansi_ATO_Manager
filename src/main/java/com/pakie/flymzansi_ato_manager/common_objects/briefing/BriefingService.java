package com.pakie.flymzansi_ato_manager.common_objects.briefing;

import com.pakie.flymzansi_ato_manager.common_objects.briefing.Briefing;

import java.util.List;

public interface BriefingService {
    List<Briefing> getAllBriefings();
    void saveBriefing(Briefing briefing);
    Briefing getBriefingById(Long Id);
    void deleteBriefingById(Long Id);
}
