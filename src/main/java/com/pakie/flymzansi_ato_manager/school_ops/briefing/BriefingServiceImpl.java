package com.pakie.flymzansi_ato_manager.school_ops.briefing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BriefingServiceImpl implements BriefingService {
    @Autowired
    private BriefingRepo briefingRepo;

    @Override
    public List<Briefing> getAllBriefings() {
        return briefingRepo.findAll();
    }

    @Override
    public void saveBriefing(Briefing briefing) {
        this.briefingRepo.save(briefing);
    }

    @Override
    public Briefing getBriefingById(Long id) {
        Optional<Briefing> optional = briefingRepo.findById(id);
        Briefing briefing = null;
        if (optional.isPresent()){
            briefing = optional.get();
        } else {
            throw new RuntimeException("The briefing with ID " + id + " does not exist");
        }
        return briefing;
    }

    @Override
    public void deleteBriefingById(Long id) {
        this.briefingRepo.deleteById(id);
    }
}
