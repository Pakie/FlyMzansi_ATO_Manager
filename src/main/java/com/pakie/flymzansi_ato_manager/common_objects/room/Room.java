package com.pakie.flymzansi_ato_manager.common_objects.room;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.common_objects.Status;
import com.pakie.flymzansi_ato_manager.common_objects.room.room_category.RoomCategory;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer seats;
    @ManyToOne(fetch = FetchType.EAGER)
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER)
    private RoomCategory roomCategory;

    public Room(String title, String description, String details, Integer seats, Status status, RoomCategory roomCategory) {
        super(title, description, details);
        this.seats = seats;
        this.status = status;
        this.roomCategory = roomCategory;
    }

    public Room() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }
}
