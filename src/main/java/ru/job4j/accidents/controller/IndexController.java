package ru.job4j.accidents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accidents.service.IAccidentService;

@Controller
public class IndexController {

    private final IAccidentService accidentService;

    @Autowired
    public IndexController(IAccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("accidents", this.accidentService.findAll());
        return "index";
    }
}