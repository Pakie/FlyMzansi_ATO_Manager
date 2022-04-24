package com.pakie.flymzansi_ato_manager.common_objects.company;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company extends CommonObject {

    private String address;

    public Company(String title, String description, String address) {
        super(title, description);
        this.address = address;
    }

    public Company() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
