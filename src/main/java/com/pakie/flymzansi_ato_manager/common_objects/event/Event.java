package com.pakie.flymzansi_ato_manager.common_objects.event;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.common_objects.Status;
import com.pakie.flymzansi_ato_manager.common_objects.room.Room;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event extends CommonObject {

    private Date startTime;
    private Date endTime;
    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;
    @Enumerated(EnumType.ORDINAL)
    @ManyToOne(fetch = FetchType.EAGER)
    private Status status;

    public Event(String title, String description, Date startTime, Date endTime, Room room, Status status) {
        super(title, description);
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
        this.status = status;
    }

    public Event() {

    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
