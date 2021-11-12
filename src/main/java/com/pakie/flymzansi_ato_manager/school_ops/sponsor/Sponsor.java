package com.pakie.flymzansi_ato_manager.school_ops.sponsor;

import com.pakie.flymzansi_ato_manager.common_objects.company.Company;
import com.pakie.flymzansi_ato_manager.common_objects.person.Person;
import com.pakie.flymzansi_ato_manager.school_ops.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sponsor")
public class Sponsor extends Person {

    private String type;
    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;
    @ManyToMany(mappedBy = "sponsors")
    List<Student> students;

    public Sponsor(String firstName, String lastName, String email, String cell, String address, String type, Company company, List<Student> students) {
        super(firstName, lastName, email, cell, address);
        this.type = type;
        this.company = company;
        this.students = students;
    }

    public Sponsor() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
