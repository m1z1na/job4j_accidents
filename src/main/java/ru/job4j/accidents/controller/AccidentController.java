package ru.job4j.accidents.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.service.IAccidentService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class AccidentController {
    private final IAccidentService accidents;

    @GetMapping("/createAccident")
    public String viewCreateAccident(Model model) {
        model.addAttribute("types", this.accidents.findAllTypes());
        model.addAttribute("rules", this.accidents.findAllRules());
        return "createAccident";
    }

    @GetMapping("/formUpdateAccident")
    public String edit(@RequestParam("id") int id, Model model) {
        Optional<Accident> accident = this.accidents.getById(id);
        if (accident.isPresent()) {
            model.addAttribute("accident", accident);
            return "editAccident";
        }
        model.addAttribute("message", "Not Found");
        return "errors/404";

    }

    @PostMapping("/saveAccident")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        accidents.create(accident);
        return "redirect:/index";
    }

    @PostMapping("/editAccident")
    public String update(@ModelAttribute Accident accident, Model model) {
        if (accidents.update(accident)) {
            return "redirect:/index";
        }
        model.addAttribute("message", "Update error");
        return "errors/404";
    }
}