package ru.job4j.accidents.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.service.IAccidentService;

@Controller
@AllArgsConstructor
public class AccidentController {
    private final IAccidentService accidents;

    @GetMapping("/createAccident")
    public String viewCreateAccident() {
        return "createAccident";
    }

    @GetMapping("/editAccident/{id}")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("accident", this.accidents.getById(id));
        return "editAccident";
    }
    @PostMapping("/saveAccident")
    public String save(@ModelAttribute Accident accident) {
        accidents.create(accident);
        return "redirect:/index";
    }
    @PostMapping("/editAccident")
    public String update(@ModelAttribute Accident accident) {
        accidents.update(accident);
        return "redirect:/index";
    }
}