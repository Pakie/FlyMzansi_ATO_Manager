package com.pakie.flymzansi_ato_manager.web;

import com.pakie.flymzansi_ato_manager.user.SetupDataLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class AppController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

}
