package com.pakie.flymzansi_ato_manager.common_objects.room.room_category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomCategoryRepo extends JpaRepository<RoomCategory, Long> {

}
