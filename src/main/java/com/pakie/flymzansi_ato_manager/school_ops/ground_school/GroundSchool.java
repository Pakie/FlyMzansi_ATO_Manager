package com.pakie.flymzansi_ato_manager.school_ops.ground_school;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.common_objects.Status;
import com.pakie.flymzansi_ato_manager.common_objects.room.Room;
import com.pakie.flymzansi_ato_manager.school_ops.subject.Subject;
import com.pakie.flymzansi_ato_manager.school_ops.instructor.Instructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ground_school")
public class GroundSchool extends CommonObject {

    private Integer avail_seats;

    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    private Subject subject;

    @ManyToOne(fetch = FetchType.EAGER)
    private Instructor instructor;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date endTime;


    public GroundSchool(String title, String description, Integer avail_seats, Double price, Room room, Subject subject, Instructor instructor, Date startTime, Date endTime, Status status) {
        super(title, description);
        this.avail_seats = avail_seats;
        this.price = price;
        this.room = room;
        this.subject = subject;
        this.instructor = instructor;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public GroundSchool() {

    }

    public Integer getAvail_seats() {
        return avail_seats;
    }

    public void setAvail_seats(Integer avail_seats) {
        this.avail_seats = avail_seats;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
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

}
