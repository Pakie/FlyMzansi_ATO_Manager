package com.pakie.flymzansi_ato_manager.booking;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.user.User;

import javax.persistence.*;
import java.util.List;

//@Entity
//@Table(name = "works")
@MappedSuperclass
public class Work extends CommonObject {

    @Column(name = "price")
    private double price;

    @Column(name = "duration")
    private int duration;

    @Column(name = "editable")
    private boolean editable;

    @Column(name = "target")
    private String targetCustomer;


    @ManyToMany
    @JoinTable(name = "works_providers", joinColumns = @JoinColumn(name = "id_work"), inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> providers;


    public Work(String title, String description, double price, int duration, boolean editable, String targetCustomer) {
        super(title, description);
        this.price = price;
        this.duration = duration;
        this.editable = editable;
        this.targetCustomer = targetCustomer;
    }

    public Work() {
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<User> getProviders() {
        return providers;
    }

    public void setProviders(List<User> providers) {
        this.providers = providers;
    }

    public boolean getEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getTargetCustomer() {
        return targetCustomer;
    }

    public void setTargetCustomer(String targetCustomer) {
        this.targetCustomer = targetCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Work)) return false;
        Work work = (Work) o;
        return super.getId().equals(work.getId());
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }
}
