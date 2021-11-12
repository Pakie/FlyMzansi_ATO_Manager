package com.pakie.flymzansi_ato_manager.flight_ops.simulator;

import com.pakie.flymzansi_ato_manager.flight_ops.simulator.Simulator;
import com.pakie.flymzansi_ato_manager.flight_ops.simulator.SimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SimulatorController {
    @Autowired
    SimulatorService simulatorService;

    //List Simulators
    @GetMapping("/simulators")
    //public String simulators(){
    public String getAllSimulators(Model model) {
        model.addAttribute("simulators", simulatorService.getAllSimulators());
        return "simulator/simulators";
    }

    @GetMapping("/simulators/add-simulator")
    public String addSimulator(Model model){
        Simulator simulator = new Simulator();
        model.addAttribute("simulator", simulator);
        return "simulator/add_simulator";
    }

    @PostMapping("/saveSimulator")
    public String saveSimulator(@ModelAttribute("simulator") Simulator simulator){
        simulatorService.saveSimulator(simulator);
        return "redirect:/simulators";
    }
    @GetMapping("/simulators/update-simulator/{id}")
    public String updateSimulator(@PathVariable(value = "id") Long id, Model model){
        Simulator simulator = simulatorService.getSimulatorById(id);
        model.addAttribute("simulator", simulator);

        return "simulator/update_simulator";
    }
    @GetMapping("/simulators/delete-simulator/{id}")
    public String deleteSimulator(@PathVariable(value = "id") Long id, Model model){
        this.simulatorService.deleteSimulatorById(id);
        return "redirect:/simulators";
    }
}
