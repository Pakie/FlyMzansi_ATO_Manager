package com.pakie.flymzansi_ato_manager.common_objects.room.room_category;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;

import javax.persistence.*;

@Entity
@Table(name = "room_category")
public class RoomCategory extends CommonObject {

    public RoomCategory(String title, String description, String details, Long id) {
        super(title, description, details);
    }

    public RoomCategory() {

    }
}
