package com.pakie.flymzansi_ato_manager.common_objects.room;

import com.pakie.flymzansi_ato_manager.common_objects.room.Room;
import com.pakie.flymzansi_ato_manager.common_objects.room.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepo roomRepo;

    @Override
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public void saveRoom(Room room) {
        this.roomRepo.save(room);
    }

    @Override
    public Room getRoomById(Long id) {
        Optional<Room> optional = roomRepo.findById(id);
        Room room = null;
        if (optional.isPresent()){
            room = optional.get();
        } else {
            throw new RuntimeException("The room with ID " + id + " does not exist");
        }
        return room;
    }

    @Override
    public void deleteRoomById(Long id) {
        this.roomRepo.deleteById(id);
    }
}
