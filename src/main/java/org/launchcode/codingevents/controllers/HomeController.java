package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class HomeController {

    @GetMapping
    public String displayIndex(Model model){
        model.addAttribute("title", "Events!");
        return "index";
    }
}
