package io.sistersdoingitforthemselves.company.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TechCompanyController {

    @GetMapping("/")
    public String getTechName(Model model) {
        // here's the basic logic for stripping out the last vowel...
        String thing = "not on my watch...";
        int lastVowelIndex = StringUtils.lastIndexOfAny(thing, "a", "e", "i", "o", "u");
        String newString = thing.substring(0, lastVowelIndex) + thing.substring(lastVowelIndex + 1);

        return "techname";
    }
}
