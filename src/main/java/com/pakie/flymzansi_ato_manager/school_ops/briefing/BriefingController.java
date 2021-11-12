package com.pakie.flymzansi_ato_manager.school_ops.briefing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BriefingController {
    @Autowired
    BriefingService briefingService;

    //List Briefings
    @GetMapping("/briefings")
    //public String briefings(){
    public String getAllBriefings(Model model) {
        model.addAttribute("briefings", briefingService.getAllBriefings());
        return "briefing/briefings";
    }

    @GetMapping("/briefings/add-briefing")
    public String addBriefing(Model model){
        Briefing briefing = new Briefing();
        model.addAttribute("briefing", briefing);
        return "briefing/add_briefing";
    }

    @PostMapping("/saveBriefing")
    public String saveBriefing(@ModelAttribute("briefing") Briefing briefing){
        briefingService.saveBriefing(briefing);
        return "redirect:/briefings";
    }
    @GetMapping("/briefings/update-briefing/{id}")
    public String updateBriefing(@PathVariable(value = "id") Long id, Model model){
        Briefing briefing = briefingService.getBriefingById(id);
        model.addAttribute("briefing", briefing);

        return "briefing/update_briefing";
    }
    @GetMapping("/briefings/delete-briefing/{id}")
    public String deleteBriefing(@PathVariable(value = "id") Long id, Model model){
        this.briefingService.deleteBriefingById(id);
        return "redirect:/briefings";
    }
}
