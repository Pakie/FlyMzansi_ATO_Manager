package com.pakie.flymzansi_ato_manager.flight_ops.simulator.sim_session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimSessionServiceImpl implements SimSessionService {
    @Autowired
    private SimSessionRepo simSessionRepo;

    @Override
    public List<SimSession> getAllSimSessions() {
        return simSessionRepo.findAll();
    }

    @Override
    public void saveSimSession(SimSession simSession) {
        this.simSessionRepo.save(simSession);
    }

    @Override
    public SimSession getSimSessionById(Long id) {
        Optional<SimSession> optional = simSessionRepo.findById(id);
        SimSession simSession = null;
        if (optional.isPresent()){
            simSession = optional.get();
        } else {
            throw new RuntimeException("The simSession with ID " + id + " does not exist");
        }
        return simSession;
    }

    @Override
    public void deleteSimSessionById(Long id) {
        this.simSessionRepo.deleteById(id);
    }
}
