package com.pakie.flymzansi_ato_manager.common_objects.room.room_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {
    @Autowired
    private RoomCategoryRepo roomCategoryRepo;

    @Override
    public List<RoomCategory> getAllRoomCategories() {
        return roomCategoryRepo.findAll();
    }

    @Override
    public void saveRoomCategory(RoomCategory roomCategory) {
        this.roomCategoryRepo.save(roomCategory);
    }

    @Override
    public RoomCategory getRoomCategoryById(Long id) {
        Optional<RoomCategory> optional = roomCategoryRepo.findById(id);
        RoomCategory roomCategory = null;
        if (optional.isPresent()){
            roomCategory = optional.get();
        } else {
            throw new RuntimeException("The roomCategory with ID " + id + " does not exist");
        }
        return roomCategory;
    }

    @Override
    public void deleteRoomCategoryById(Long id) {
        this.roomCategoryRepo.deleteById(id);
    }
}
