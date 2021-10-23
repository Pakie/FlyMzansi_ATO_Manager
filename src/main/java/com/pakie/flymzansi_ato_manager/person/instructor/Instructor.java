package com.pakie.flymzansi_ato_manager.person.instructor;

import com.pakie.flymzansi_ato_manager.common_objects.aircraft.Aircraft;
import com.pakie.flymzansi_ato_manager.common_objects.department.Department;
import com.pakie.flymzansi_ato_manager.common_objects.employment_position.EmploymentPosition;
import com.pakie.flymzansi_ato_manager.common_objects.employment_type.EmploymentType;
import com.pakie.flymzansi_ato_manager.common_objects.ground_school.GroundSchool;
import com.pakie.flymzansi_ato_manager.common_objects.license.License;
import com.pakie.flymzansi_ato_manager.common_objects.rating.Rating;
import com.pakie.flymzansi_ato_manager.person.employee.Employee;
import com.pakie.flymzansi_ato_manager.person.student.Student;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor extends Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nextOfKin;
    private Long nextOfKinContact;
    private Double flyingHours;
    @ManyToOne(fetch = FetchType.EAGER)
    private License license;
    private String licenseNumber;
    private LocalDate licenseExpiryDate;
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

    public Instructor(String firstName, String lastName, String name, String email, String cell, String address, LocalDate startDate, Double salary, Long taxNumber, Department department, EmploymentType employmentType, EmploymentPosition employmentPosition, String nextOfKin, Long nextOfKinContact, Double flyingHours, License license, String licenseNumber, LocalDate licenseExpiryDate, LocalDate medicalExpiryDate, List<GroundSchool> groundSchools, List<Aircraft> aircrafts, List<Student> students, List<Rating> ratings) {
        super(firstName, lastName, name, email, cell, address, startDate, salary, taxNumber, department, employmentType, employmentPosition);
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
