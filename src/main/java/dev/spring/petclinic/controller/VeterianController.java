package dev.spring.petclinic.controller;

import dev.spring.petclinic.service.VeterianService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/vets")
@RequiredArgsConstructor
@Slf4j
public class VeterianController {
    private final VeterianService veterianService;

    @GetMapping
    public String showVeterians(Model model) {
        model.addAttribute("listVets", veterianService.getAllVeterians());
        return "vets/vetList";
    }
}
