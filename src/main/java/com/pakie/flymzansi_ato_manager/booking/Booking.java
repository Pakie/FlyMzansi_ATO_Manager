package com.pakie.flymzansi_ato_manager.booking;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@JsonSerialize(using = BookingSerializer.class)
public class Booking extends CommonObject implements Comparable<Booking> {

    @Column(name = "start")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime start;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "end")
    private LocalDateTime end;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "canceled_at")
    private LocalDateTime canceledAt;

    @OneToOne
    @JoinColumn(name = "id_canceler")
    private User canceler;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookingStatus status;

    //@ManyToOne
    //@JoinColumn(name = "id_customer")
    //private Customer customer;

    /*@ManyToOne
    @JoinColumn(name = "id_provider")
    private Provider provider;*/

    /*@ManyToOne
    @JoinColumn(name = "id_work")
    private Work work;*/

    public Booking() {
    }

    public Booking(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Booking o) {
        return this.getStart().compareTo(o.getStart());
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }


    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public User getCanceler() {
        return canceler;
    }

    public void setCanceler(User canceler) {
        this.canceler = canceler;
    }

    public LocalDateTime getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(LocalDateTime canceledAt) {
        this.canceledAt = canceledAt;
    }

}