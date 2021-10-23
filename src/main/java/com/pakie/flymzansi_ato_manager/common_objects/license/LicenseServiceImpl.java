package com.pakie.flymzansi_ato_manager.common_objects.license;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseServiceImpl implements LicenseService {
    @Autowired
    private LicenseRepo licenseRepo;

    @Override
    public List<License> getAllLicenses() {
        return licenseRepo.findAll();
    }

    @Override
    public void saveLicense(License license) {
        this.licenseRepo.save(license);
    }

    @Override
    public License getLicenseById(Long id) {
        Optional<License> optional = licenseRepo.findById(id);
        License license = null;
        if (optional.isPresent()){
            license = optional.get();
        } else {
            throw new RuntimeException("The license with ID " + id + " does not exist");
        }
        return license;
    }

    @Override
    public void deleteLicenseById(Long id) {
        this.licenseRepo.deleteById(id);
    }
}
