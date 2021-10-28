package com.pakie.flymzansi_ato_manager.common_objects.position;

import java.util.List;

public interface PositionService {
    List<Position> getAllPositions();
    void savePosition(Position position);
    Position getPositionById(Long Id);
    void deletePositionById(Long Id);
}
