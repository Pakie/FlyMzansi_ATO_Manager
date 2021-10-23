package com.pakie.flymzansi_ato_manager.common_objects.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController {
    @Autowired
    CompanyService companyService;

    //List Companies
    @GetMapping("/companies")
    //public String companys(){
    public String getAllCompanys(Model model) {
        model.addAttribute("companies", companyService.getAllCompanies());
        return "company/companies";
    }

    @GetMapping("/companies/add-company")
    public String addCompany(Model model){
        Company company = new Company();
        model.addAttribute("company", company);
        return "company/add_company";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company){
        companyService.saveCompany(company);
        return "redirect:/companies";
    }
    @GetMapping("/companies/update-company/{id}")
    public String updateCompany(@PathVariable(value = "id") Long id, Model model){
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);

        return "company/update_company";
    }
    @GetMapping("/companies/delete-company/{id}")
    public String deleteCompany(@PathVariable(value = "id") Long id, Model model){
        this.companyService.deleteCompanyById(id);
        return "redirect:/companies";
    }
}
