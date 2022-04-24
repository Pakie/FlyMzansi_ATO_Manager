package com.pakie.flymzansi_ato_manager.booking;
/*
import com.pakie.flymzansi_ato_manager.user.Role;
import com.pakie.flymzansi_ato_manager.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "provider")
@PrimaryKeyJoinColumn(name = "id_provider")
public class Provider extends User {
    @OneToMany(mappedBy = "provider")
    private List<Booking> bookings;

    @ManyToMany
    @JoinTable(name = "works_providers", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_work"))
    private List<Work> works;

    @OneToOne(mappedBy = "provider", cascade = {CascadeType.ALL})
    private WorkingPlan workingPlan;

    public Provider() {
    }

    public Provider(UserForm userFormDTO, String encryptedPassword, Collection<Role> roles, WorkingPlan workingPlan) {
        super(userFormDTO, encryptedPassword, roles);
        this.workingPlan = workingPlan;
        workingPlan.setProvider(this);
        this.works = userFormDTO.getWorks();
    }

    @Override
    public void update(UserForm updateData) {
        super.update(updateData);
        this.works = updateData.getWorks();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public WorkingPlan getWorkingPlan() {
        return workingPlan;
    }

    public void setWorkingPlan(WorkingPlan workingPlan) {
        this.workingPlan = workingPlan;
    }

    public List<Work> getCorporateWorks() {
        List<Work> corporateWorks = new ArrayList<>();
        for (Work w : works) {
            if (w.getTargetCustomer().equals("corporate")) {
                corporateWorks.add(w);
            }
        }
        return corporateWorks;
    }

    public List<Work> getRetailWorks() {
        List<Work> retailWorks = new ArrayList<>();
        for (Work w : works) {
            if (w.getTargetCustomer().equals("retail")) {
                retailWorks.add(w);
            }
        }
        return retailWorks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Provider provider = (Provider) o;
        return provider.getId().equals(this.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookings, works, workingPlan);
    }
}*/
