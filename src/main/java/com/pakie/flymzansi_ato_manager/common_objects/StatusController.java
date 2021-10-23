package com.pakie.flymzansi_ato_manager.common_objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping("/statuses")
    public String getAllStatuses(Model model) {
        model.addAttribute("statuses", statusService.getAllStatuses());
        return "status/statuses";
    }

    @GetMapping("/statuses/add-status")
    public String addStatus(Model model){
        Status status = new Status();
        model.addAttribute("status", status);
        return "status/add_status";
    }

    @PostMapping("/saveStatus")
    public String saveStatus(@ModelAttribute("status") Status status) {
        statusService.SaveStatus(status);
        return "redirect:/statuses";
    }

    @GetMapping("/statuses/update-status/{id}")
    public String updateStatus(@PathVariable(value = "id") Long id, Model model){
         Status status = statusService.getStatusById(id);
        model.addAttribute("status", status);

        return "status/update_status";
    }

    @GetMapping("/statuses/delete-status")
    public String deleteStatus(@PathVariable(value = "id") Long id, Model model){
        this.statusService.deleteStatusById(id);
        return "redirect:/statuses";
    }

}
