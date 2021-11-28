package com.pakie.flymzansi_ato_manager.common_objects.person.customer;

import com.pakie.flymzansi_ato_manager.common_objects.person.Person;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends Person {

    public Customer(String firstName, String lastName, String email, String cell, String address, String image) {
        super(firstName, lastName, email, cell, address, image);
    }

    public Customer() {

    }
}
