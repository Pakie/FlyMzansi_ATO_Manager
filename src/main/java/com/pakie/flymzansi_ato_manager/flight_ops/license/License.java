package com.pakie.flymzansi_ato_manager.flight_ops.license;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;

import javax.persistence.*;

@Entity
@Table(name = "license")
public class License extends CommonObject {

    public License(String title, String description, String details, Long id) {
        super(title, description, details);
    }

    public License() {

    }
}
