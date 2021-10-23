package com.pakie.flymzansi_ato_manager.common_objects.room.room_category;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;

import javax.persistence.*;

@Entity
@Table(name = "room_category")
public class RoomCategory extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public RoomCategory(String title, String description, String details, Long id) {
        super(title, description, details);
        this.id = id;
    }

    public RoomCategory() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
