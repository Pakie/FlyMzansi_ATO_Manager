package com.pakie.flymzansi_ato_manager.flight_ops.mechanic;

import java.util.List;

public interface MechanicService {
    List<Mechanic> getAllMechanics();
    Mechanic saveMechanic(Mechanic mechanic);
    Mechanic getMechanicById(Long Id);
    void deleteMechanicById(Long Id);
}
