package com.pakie.flymzansi_ato_manager.flight_ops.license;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepo extends JpaRepository<License, Long> {

}
