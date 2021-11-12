package com.pakie.flymzansi_ato_manager.flight_ops.simulator.sim_session;

import com.pakie.flymzansi_ato_manager.flight_ops.simulator.SimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SimSessionController {
    @Autowired
    SimSessionService simSessionService;

    @Autowired
    SimulatorService simulatorService;

    //List SimSessions
    @GetMapping("/simulators/sim-sessions")
    //public String simSessions(){
    public String getAllSimSessions(Model model) {
        model.addAttribute("simSessions", simSessionService.getAllSimSessions());
        return "simulator/sim_session/sim_sessions";
    }

    @GetMapping("/simulators/sim-sessions/add-sim-session")
    public String addSimSession(Model model){
        SimSession simSession = new SimSession();
        model.addAttribute("simSession", simSession);
        model.addAttribute("simulators", simulatorService.getAllSimulators());

        return "simulator/sim_session/add_sim_session";
    }

    @PostMapping("/saveSimSession")
    public String saveSimSession(@ModelAttribute("simSession") SimSession simSession){
        simSessionService.saveSimSession(simSession);
        return "redirect:/simulators/sim-sessions";
    }
    @GetMapping("/simulators/sim-sessions/update-sim-session/{id}")
    public String updateSimSession(@PathVariable(value = "id") Long id, Model model){
        SimSession simSession = simSessionService.getSimSessionById(id);
        model.addAttribute("simSession", simSession);
        model.addAttribute("simulators", simulatorService.getAllSimulators());

        return "simulator/sim_session/update_sim_session";
    }
    @GetMapping("/simulators/sim-sessions/delete-sim-session/{id}")
    public String deleteSimSession(@PathVariable(value = "id") Long id, Model model){
        this.simSessionService.deleteSimSessionById(id);
        return "redirect:/simulators/sim-sessions";
    }
}
