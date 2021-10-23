package com.pakie.flymzansi_ato_manager.common_objects.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    void saveCompany(Company company);
    Company getCompanyById(Long Id);
    void deleteCompanyById(Long Id);
}
