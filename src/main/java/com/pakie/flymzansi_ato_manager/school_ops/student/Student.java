package com.pakie.flymzansi_ato_manager.school_ops.student;

import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;
import com.pakie.flymzansi_ato_manager.school_ops.course.Course;
import com.pakie.flymzansi_ato_manager.flight_ops.license.License;
import com.pakie.flymzansi_ato_manager.flight_ops.rating.Rating;
import com.pakie.flymzansi_ato_manager.common_objects.person.Person;
import com.pakie.flymzansi_ato_manager.school_ops.instructor.Instructor;
import com.pakie.flymzansi_ato_manager.school_ops.sponsor.Sponsor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student extends Person {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne(fetch = FetchType.EAGER)
    private License license;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate licenseExpiryDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate medicalExpiryDate;
    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "students_ratings",
            joinColumns = @JoinColumn(
                    name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "rating_id", referencedColumnName = "id"
            )
    )
    List<Rating> ratings;
    @ManyToMany
    @JoinTable(name = "students_sponsors",
            joinColumns = @JoinColumn(
                    name = "student_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "sponsor_id", referencedColumnName = "id"
            )
    )
    Set<Sponsor> sponsors;
    private String nextOfKin;
    private Long nextOfKinContact;
    private Double flyingHours;

    public Student(String firstName, String lastName, String email, String cell, String address, String image, LocalDate startDate, Instructor instructor, Course course, License license, LocalDate licenseExpiryDate, LocalDate medicalExpiryDate, Aircraft aircraft, List<Rating> ratings, Set<Sponsor> sponsors, String nextOfKin, Long nextOfKinContact, Double flyingHours) {
        super(firstName, lastName, email, cell, address, image);
        this.startDate = startDate;
        this.instructor = instructor;
        this.course = course;
        this.license = license;
        this.licenseExpiryDate = licenseExpiryDate;
        this.medicalExpiryDate = medicalExpiryDate;
        this.aircraft = aircraft;
        this.ratings = ratings;
        this.sponsors = sponsors;
        this.nextOfKin = nextOfKin;
        this.nextOfKinContact = nextOfKinContact;
        this.flyingHours = flyingHours;
    }

    public Student() {

    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(Set<Sponsor> sponsors) {
        this.sponsors = sponsors;
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
}
