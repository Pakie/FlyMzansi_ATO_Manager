package com.pakie.flymzansi_ato_manager.person.mechanic;

import com.pakie.flymzansi_ato_manager.common_objects.license.License;
import com.pakie.flymzansi_ato_manager.person.Person;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "mechanic")
public class Mechanic extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    private License license;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate licenseExpiryDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate medicalExpiryDate;

    public Mechanic(String firstName, String lastName, String email, String cell, String address, License license, LocalDate licenseExpiryDate, LocalDate medicalExpiryDate) {
        super(firstName, lastName, email, cell, address);
        this.license = license;
        this.licenseExpiryDate = licenseExpiryDate;
        this.medicalExpiryDate = medicalExpiryDate;
    }

    public Mechanic() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public LocalDate getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public void setLicenseExpiryDate(LocalDate licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }

    public LocalDate getMedicalExpiryDate() {
        return medicalExpiryDate;
    }

    public void setMedicalExpiryDate(LocalDate medicalExpiryDate) {
        this.medicalExpiryDate = medicalExpiryDate;
    }
}
