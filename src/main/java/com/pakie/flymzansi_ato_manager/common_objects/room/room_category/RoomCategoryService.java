package com.pakie.flymzansi_ato_manager.common_objects.room.room_category;

import java.util.List;

public interface RoomCategoryService {
    List<RoomCategory> getAllRoomCategories();
    void saveRoomCategory(RoomCategory roomCategory);
    RoomCategory getRoomCategoryById(Long Id);
    void deleteRoomCategoryById(Long Id);
}
