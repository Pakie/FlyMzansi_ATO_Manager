package com.pakie.flymzansi_ato_manager.common_objects.license;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LicenseController {
    @Autowired
    LicenseService licenseService;

    //List Licenses
    @GetMapping("/licenses")
    //public String licenses(){
    public String getAllLicenses(Model model) {
        model.addAttribute("licenses", licenseService.getAllLicenses());
        return "license/licenses";
    }

    @GetMapping("/licenses/add-license")
    public String addLicense(Model model){
        License license = new License();
        model.addAttribute("license", license);
        return "license/add_license";
    }

    @PostMapping("/saveLicense")
    public String saveLicense(@ModelAttribute("license") License license){
        licenseService.saveLicense(license);
        return "redirect:/licenses";
    }
    @GetMapping("/licenses/update-license/{id}")
    public String updateLicense(@PathVariable(value = "id") Long id, Model model){
        License license = licenseService.getLicenseById(id);
        model.addAttribute("license", license);

        return "license/update_license";
    }
    @GetMapping("/licenses/delete-license/{id}")
    public String deleteLicense(@PathVariable(value = "id") Long id, Model model){
        this.licenseService.deleteLicenseById(id);
        return "redirect:/licenses";
    }
}
