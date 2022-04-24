package com.pakie.flymzansi_ato_manager.school_ops.exam;

import com.pakie.flymzansi_ato_manager.booking.Work;
import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.common_objects.room.Room;
import com.pakie.flymzansi_ato_manager.school_ops.invigilator.Invigilator;
import com.pakie.flymzansi_ato_manager.school_ops.subject.Subject;

import javax.persistence.*;

@Entity
@Table(name = "exam")
public class Exam extends Work {

    @ManyToOne(fetch = FetchType.EAGER)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "invigilator_id")
    private Invigilator invigilator;
    private Double passMark;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room examRoom;


    public Exam(String title, String description, double price, int duration, boolean editable, String targetCustomer, Subject subject, Invigilator invigilator, Double passMark, Room examRoom) {
        super(title, description, price, duration, editable, targetCustomer);
        this.subject = subject;
        this.invigilator = invigilator;
        this.passMark = passMark;
        this.examRoom = examRoom;
    }

    public Exam() {

    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Invigilator getInvigilator() {
        return invigilator;
    }

    public void setInvigilator(Invigilator invigilator) {
        this.invigilator = invigilator;
    }

    public Double getPassMark() {
        return passMark;
    }

    public void setPassMark(Double passMark) {
        this.passMark = passMark;
    }

    public Room getExamRoom() {
        return examRoom;
    }

    public void setExamRoom(Room examRoom) {
        this.examRoom = examRoom;
    }
}
