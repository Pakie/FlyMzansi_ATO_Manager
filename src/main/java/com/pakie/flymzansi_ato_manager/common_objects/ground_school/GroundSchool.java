package com.pakie.flymzansi_ato_manager.common_objects.ground_school;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.common_objects.Status;
import com.pakie.flymzansi_ato_manager.common_objects.room.Room;
import com.pakie.flymzansi_ato_manager.common_objects.subject.Subject;
import com.pakie.flymzansi_ato_manager.person.instructor.Instructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ground_school")
public class GroundSchool extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer seats;
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    private Subject subject;

    @ManyToOne(fetch = FetchType.EAGER)
    private Instructor instructor;
    private Date startTime;
    private Date endTime;
    @ManyToOne(fetch = FetchType.EAGER)
    private Status status;

    public GroundSchool(String title, String description, String details, Integer seats, Double price, Room room, Subject subject, Instructor instructor, Date startTime, Date endTime, Status status) {
        super(title, description, details);
        this.seats = seats;
        this.price = price;
        this.room = room;
        this.subject = subject;
        this.instructor = instructor;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public GroundSchool() {

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
