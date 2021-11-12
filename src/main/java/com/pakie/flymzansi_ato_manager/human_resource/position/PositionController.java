package com.pakie.flymzansi_ato_manager.human_resource.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PositionController {
    @Autowired
    PositionService positionService;

    //List EmploymentPositions
    @GetMapping("/employees/employment-positions")
    //public String employmentPositions(){
    public String getAllPositions(Model model) {
        model.addAttribute("positions", positionService.getAllPositions());
        return "employee/employment_position/employment_positions";
    }

    @GetMapping("employees/employment-positions/add-employment-position")
    public String addPosition(Model model){
        Position position = new Position();
        model.addAttribute("position", position);
        return "employee/employment_position/add_employment_position";
    }

    @PostMapping("/savePosition")
    public String savePosition(@ModelAttribute("position") Position position){
        positionService.savePosition(position);
        return "redirect:/employees/employment-positions";
    }
    @GetMapping("employees/employment-positions/update-employment-position/{id}")
    public String updatePosition(@PathVariable(value = "id") Long id, Model model){
        Position position = positionService.getPositionById(id);
        model.addAttribute("position", position);

        return "employee/employment_position/update_employment_position";
    }
    @GetMapping("employees/employment-positions/delete-employment-position/{id}")
    public String deletePosition(@PathVariable(value = "id") Long id, Model model){
        this.positionService.deletePositionById(id);
        return "redirect:/employees/employment-positions";
    }
}
