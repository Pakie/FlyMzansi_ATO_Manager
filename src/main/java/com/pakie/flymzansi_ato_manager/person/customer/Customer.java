package com.pakie.flymzansi_ato_manager.person.customer;

import com.pakie.flymzansi_ato_manager.person.Person;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Customer(String firstName, String lastName, String email, String cell, String address, Long id) {
        super(firstName, lastName, email, cell, address);
        this.id = id;
    }

    public Customer() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
