package com.pakie.flymzansi_ato_manager.common_objects.license;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;

import javax.persistence.*;

@Entity
@Table(name = "license")
public class License extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public License(String title, String description, String details, Long id) {
        super(title, description, details);
        this.id = id;
    }

    public License() {

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
