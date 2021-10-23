package com.pakie.flymzansi_ato_manager.common_objects.license;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepo extends JpaRepository<License, Long> {

}
