package com.pakie.flymzansi_ato_manager.common_objects.room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    void saveRoom(Room room);
    Room getRoomById(Long Id);
    void deleteRoomById(Long Id);
}
