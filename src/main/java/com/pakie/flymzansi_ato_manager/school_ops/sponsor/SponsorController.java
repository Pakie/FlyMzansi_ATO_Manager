package com.pakie.flymzansi_ato_manager.school_ops.sponsor;

import com.pakie.flymzansi_ato_manager.common_objects.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SponsorController {
    @Autowired
    SponsorService sponsorService;

    @Autowired
    CompanyService companyService;

    //List Sponsors
    @GetMapping("/sponsors")
    //public String sponsors(){
    public String getAllSponsors(Model model) {
        model.addAttribute("sponsors", sponsorService.getAllSponsors());
        return "sponsor/sponsors";
    }

    @GetMapping("/sponsors/add-sponsor")
    public String addSponsor(Model model){
        Sponsor sponsor = new Sponsor();
        model.addAttribute("sponsor", sponsor);
        model.addAttribute("companies", companyService.getAllCompanies());

        return "sponsor/add_sponsor";
    }

    @PostMapping("/saveSponsor")
    public String saveSponsor(@ModelAttribute("sponsor") Sponsor sponsor){
        sponsorService.saveSponsor(sponsor);
        return "redirect:/sponsors";
    }
    @GetMapping("/sponsors/update-sponsor/{id}")
    public String updateSponsor(@PathVariable(value = "id") Long id, Model model){
        Sponsor sponsor = sponsorService.getSponsorById(id);
        model.addAttribute("sponsor", sponsor);
        model.addAttribute("companies", companyService.getAllCompanies());

        return "sponsor/update_sponsor";
    }
    @GetMapping("/sponsors/delete-sponsor/{id}")
    public String deleteSponsor(@PathVariable(value = "id") Long id, Model model){
        this.sponsorService.deleteSponsorById(id);
        return "redirect:/sponsors";
    }
}
