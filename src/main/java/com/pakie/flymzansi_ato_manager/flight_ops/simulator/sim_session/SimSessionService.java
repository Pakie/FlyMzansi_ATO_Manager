package com.pakie.flymzansi_ato_manager.flight_ops.simulator.sim_session;

import java.util.List;

public interface SimSessionService {
    List<SimSession> getAllSimSessions();
    void saveSimSession(SimSession simSession);
    SimSession getSimSessionById(Long Id);
    void deleteSimSessionById(Long Id);
}
