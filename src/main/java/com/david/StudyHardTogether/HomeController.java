package com.david.StudyHardTogether;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/bowling")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "bowling";
    }

    @GetMapping("/three")
    public String three() {
        return "three";
    }

    @GetMapping("/four")
    public String four() {
        return "four";
    }

    @GetMapping("/website")
    public String website() {
        return "website";
    }
}
