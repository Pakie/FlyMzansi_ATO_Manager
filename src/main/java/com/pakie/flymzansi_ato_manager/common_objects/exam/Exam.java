package com.pakie.flymzansi_ato_manager.common_objects.exam;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.common_objects.subject.Subject;

import javax.persistence.*;

@Entity
@Table(name = "exam")
public class Exam extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Subject subject;
    private Double passMark;
    private Double price;

    public Exam(String title, String description, String details, Subject subject, Double passMark, Double price) {
        super(title, description, details);
        this.subject = subject;
        this.passMark = passMark;
        this.price = price;
    }

    public Exam() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
