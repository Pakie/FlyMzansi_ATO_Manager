package com.pakie.flymzansi_ato_manager.school_ops.exam;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.school_ops.subject.Subject;

import javax.persistence.*;

@Entity
@Table(name = "exam")
public class Exam extends CommonObject {

    @ManyToOne(fetch = FetchType.EAGER)
    private Subject subject;
    private Double duration;
    private Double passMark;
    private Double price;

    public Exam(String title, String description, String details, Subject subject, Double duration, Double passMark, Double price) {
        super(title, description, details);
        this.subject = subject;
        this.duration = duration;
        this.passMark = passMark;
        this.price = price;
    }

    public Exam() {

    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getPassMark() {
        return passMark;
    }

    public void setPassMark(Double passMark) {
        this.passMark = passMark;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
