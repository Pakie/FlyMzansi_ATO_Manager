package com.pakie.flymzansi_ato_manager.flight_ops.mechanic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicServiceImpl implements MechanicService {
    @Autowired
    private MechanicRepo mechanicRepo;

    @Override
    public List<Mechanic> getAllMechanics() {
        return mechanicRepo.findAll();
    }

    @Override
    public Mechanic saveMechanic(Mechanic mechanic) {
        this.mechanicRepo.save(mechanic);
        return mechanic;
    }

    @Override
    public Mechanic getMechanicById(Long id) {
        Optional<Mechanic> optional = mechanicRepo.findById(id);
        Mechanic mechanic = null;
        if (optional.isPresent()){
            mechanic = optional.get();
        } else {
            throw new RuntimeException("The mechanic with ID " + id + " does not exist");
        }
        return mechanic;
    }

    @Override
    public void deleteMechanicById(Long id) {
        this.mechanicRepo.deleteById(id);
    }
}
