package com.pakie.flymzansi_ato_manager.common_objects.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public void saveCompany(Company company) {
        this.companyRepo.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        Optional<Company> optional = companyRepo.findById(id);
        Company company = null;
        if (optional.isPresent()){
            company = optional.get();
        } else {
            throw new RuntimeException("The company with ID " + id + " does not exist");
        }
        return company;
    }

    @Override
    public void deleteCompanyById(Long id) {
        this.companyRepo.deleteById(id);
    }
}
