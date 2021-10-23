package com.pakie.flymzansi_ato_manager.person.sponsor;

import com.pakie.flymzansi_ato_manager.common_objects.company.Company;
import com.pakie.flymzansi_ato_manager.person.Person;
import com.pakie.flymzansi_ato_manager.person.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sponsor")
public class Sponsor extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;
    @ManyToMany(mappedBy = "sponsors")
    List<Student> students;

    public Sponsor(String firstName, String lastName, String name, String email, String cell, String address, String type, Company company, List<Student> students) {
        super(firstName, lastName, name, email, cell, address);
        this.type = type;
        this.company = company;
        this.students = students;
    }

    public Sponsor() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
