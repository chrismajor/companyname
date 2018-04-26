package io.sistersdoingitforthemselves.company.controller;

import io.sistersdoingitforthemselves.company.service.CompanyNameService;
import io.sistersdoingitforthemselves.company.service.FaceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TechCompanyController {

    @Autowired
    CompanyNameService techCompanyService;

    @Autowired
    FaceService faceService;

    @GetMapping("/")
    public String getTechName(Model model) {
        String companyName = techCompanyService.getCompanyName();
        String face = faceService.getRandomFace();
        List<String> companyNames = new ArrayList<>();
        companyNames.add(companyName);
        model.addAttribute("companyNames", companyNames);
        model.addAttribute("face", face);
        return "techname";
    }
}
