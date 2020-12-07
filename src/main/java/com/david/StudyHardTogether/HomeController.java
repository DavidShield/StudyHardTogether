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
    public String three(String name, Model model) {
        return "three";
    }

    @GetMapping("/four")
    public String four(String name, Model model) {
        return "four";
    }
}
