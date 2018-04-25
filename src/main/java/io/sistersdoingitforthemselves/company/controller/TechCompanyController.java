package io.sistersdoingitforthemselves.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TechCompanyController {

    @GetMapping("/")
    public String getTechName(Model model) {
        return "techname";
    }
}
