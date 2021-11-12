package com.pakie.flymzansi_ato_manager.human_resource.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepo positionRepo;

    @Override
    public List<Position> getAllPositions() {
        return positionRepo.findAll();
    }

    @Override
    public void savePosition(Position position) {
        this.positionRepo.save(position);
    }

    @Override
    public Position getPositionById(Long id) {
        Optional<Position> optional = positionRepo.findById(id);
        Position position = null;
        if (optional.isPresent()){
            position = optional.get();
        } else {
            throw new RuntimeException("The employmentPosition with ID " + id + " does not exist");
        }
        return position;
    }

    @Override
    public void deletePositionById(Long id) {
        this.positionRepo.deleteById(id);
    }
}
