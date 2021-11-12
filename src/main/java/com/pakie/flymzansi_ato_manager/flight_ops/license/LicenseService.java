package com.pakie.flymzansi_ato_manager.flight_ops.license;

import java.util.List;

public interface LicenseService {
    List<License> getAllLicenses();
    void saveLicense(License license);
    License getLicenseById(Long Id);
    void deleteLicenseById(Long Id);
}
