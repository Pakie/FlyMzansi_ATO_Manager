package com.pakie.flymzansi_ato_manager.person.mechanic;

import java.util.List;

public interface MechanicService {
    List<Mechanic> getAllMechanics();
    void saveMechanic(Mechanic mechanic);
    Mechanic getMechanicById(Long Id);
    void deleteMechanicById(Long Id);
}
