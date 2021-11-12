package com.pakie.flymzansi_ato_manager.school_ops.sponsor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorServiceImpl implements SponsorService {
    @Autowired
    private SponsorRepo sponsorRepo;

    @Override
    public List<Sponsor> getAllSponsors() {
        return sponsorRepo.findAll();
    }

    @Override
    public void saveSponsor(Sponsor sponsor) {
        this.sponsorRepo.save(sponsor);
    }

    @Override
    public Sponsor getSponsorById(Long id) {
        Optional<Sponsor> optional = sponsorRepo.findById(id);
        Sponsor sponsor = null;
        if (optional.isPresent()){
            sponsor = optional.get();
        } else {
            throw new RuntimeException("The sponsor with ID " + id + " does not exist");
        }
        return sponsor;
    }

    @Override
    public void deleteSponsorById(Long id) {
        this.sponsorRepo.deleteById(id);
    }
}
