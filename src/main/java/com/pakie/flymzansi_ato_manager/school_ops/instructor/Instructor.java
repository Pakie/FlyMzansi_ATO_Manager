package com.pakie.flymzansi_ato_manager.school_ops.instructor;

import com.pakie.flymzansi_ato_manager.booking.WorkingPlan;
import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;
import com.pakie.flymzansi_ato_manager.flight_ops.flight.TrainingFlight;
import com.pakie.flymzansi_ato_manager.human_resource.department.Department;
import com.pakie.flymzansi_ato_manager.human_resource.position.Position;
import com.pakie.flymzansi_ato_manager.human_resource.employment_type.EmploymentType;
import com.pakie.flymzansi_ato_manager.school_ops.ground_school.GroundSchool;
import com.pakie.flymzansi_ato_manager.flight_ops.license.License;
import com.pakie.flymzansi_ato_manager.flight_ops.rating.Rating;
import com.pakie.flymzansi_ato_manager.human_resource.employee.Employee;
import com.pakie.flymzansi_ato_manager.school_ops.student.Student;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Instructor extends Employee {

    private String nextOfKin;
    private Long nextOfKinContact;
    private Double flyingHours;
    @ManyToOne(fetch = FetchType.EAGER)
    private License license;
    private String licenseNumber;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate licenseExpiryDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate medicalExpiryDate;
    @OneToMany(mappedBy = "instructor")
    List<GroundSchool> groundSchools;
    @ManyToMany
    @JoinTable(name = "instructors_aircrafts",
                joinColumns = @JoinColumn(
                        name = "instructor_id",
                        referencedColumnName = "id"
                ), inverseJoinColumns = @JoinColumn(
                        name = "aircraft_id",
                    referencedColumnName = "id")
            )
    List<Aircraft> aircrafts;

    @OneToMany(mappedBy = "instructor")
    List<Student> students;

    @ManyToMany
    @JoinTable(name = "instructors_ratings",
            joinColumns = @JoinColumn(
                    name = "instructor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "rating_id", referencedColumnName = "id"
            )
    )
    List<Rating> ratings;

    @OneToMany(mappedBy = "instructor")
    List<TrainingFlight> trainingFlights;

    @OneToOne(mappedBy = "instructor", cascade = {CascadeType.ALL})
    private WorkingPlan workingPlan;



    public Instructor(String firstName, String lastName, String email, String cell, String address, String image, LocalDate startDate, Double salary, Long taxNumber, Department department, EmploymentType employmentType, Position employmentPosition, String nextOfKin, Long nextOfKinContact, Double flyingHours, License license, String licenseNumber, LocalDate licenseExpiryDate, LocalDate medicalExpiryDate, List<GroundSchool> groundSchools, List<Aircraft> aircrafts, List<Student> students, List<Rating> ratings) {
        super(firstName, lastName, email, cell, address, image, startDate, salary, taxNumber, department, employmentType, employmentPosition);
        this.nextOfKin = nextOfKin;
        this.nextOfKinContact = nextOfKinContact;
        this.flyingHours = flyingHours;
        this.license = license;
        this.licenseNumber = licenseNumber;
        this.licenseExpiryDate = licenseExpiryDate;
        this.medicalExpiryDate = medicalExpiryDate;
        this.groundSchools = groundSchools;
        this.aircrafts = aircrafts;
        this.students = students;
        this.ratings = ratings;
    }

    public Instructor() {

    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(String nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public Long getNextOfKinContact() {
        return nextOfKinContact;
    }

    public void setNextOfKinContact(Long nextOfKinContact) {
        this.nextOfKinContact = nextOfKinContact;
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

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
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

    public List<GroundSchool> getGroundSchools() {
        return groundSchools;
    }

    public void setGroundSchools(List<GroundSchool> groundSchools) {
        this.groundSchools = groundSchools;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
