package com.pakie.flymzansi_ato_manager.flight_ops.pilot;

import java.util.List;

public interface PilotService {
    List<Pilot> getAllPilots();
    void savePilot(Pilot pilot);
    Pilot getPilotById(Long Id);
    void deletePilotById(Long Id);
}
