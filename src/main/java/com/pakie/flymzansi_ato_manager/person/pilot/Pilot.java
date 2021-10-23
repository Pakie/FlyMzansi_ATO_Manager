package com.pakie.flymzansi_ato_manager.person.pilot;

import com.pakie.flymzansi_ato_manager.common_objects.license.License;
import com.pakie.flymzansi_ato_manager.common_objects.rating.Rating;
import com.pakie.flymzansi_ato_manager.person.Person;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pilot")
public class Pilot extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double flyingHours;
    @ManyToOne(fetch = FetchType.EAGER)
    private License license;
    private Date licenseExpiryDate;
    private Date medicalExpiryDate;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pilots_ratings",
            joinColumns = @JoinColumn(
                    name = "pilot_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "rating_id", referencedColumnName = "id"
            )
    )
    List<Rating> ratings;

    public Pilot(String firstName, String lastName, String name, String email, String cell, String address, Double flyingHours, License license, Date licenseExpiryDate, Date medicalExpiryDate, List<Rating> ratings) {
        super(firstName, lastName, name, email, cell, address);
        this.flyingHours = flyingHours;
        this.license = license;
        this.licenseExpiryDate = licenseExpiryDate;
        this.medicalExpiryDate = medicalExpiryDate;
        this.ratings = ratings;
    }

    public Pilot() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Double getFlyingHours() {
        return flyingHours;
    }

    public void setFlyingHours(Double flyingHours) {
        this.flyingHours = flyingHours;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public Date getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public void setLicenseExpiryDate(Date licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }

    public Date getMedicalExpiryDate() {
        return medicalExpiryDate;
    }

    public void setMedicalExpiryDate(Date medicalExpiryDate) {
        this.medicalExpiryDate = medicalExpiryDate;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
