package com.pakie.flymzansi_ato_manager.common_objects.sim_session;

import java.util.List;

public interface SimSessionService {
    List<SimSession> getAllSimSessions();
    void saveSimSession(SimSession simSession);
    SimSession getSimSessionById(Long Id);
    void deleteSimSessionById(Long Id);
}
