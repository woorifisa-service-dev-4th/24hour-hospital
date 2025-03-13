package dev.spring.petclinic.controller;

import dev.spring.petclinic.dto.VetetrianResponseDto;
import dev.spring.petclinic.service.VeterianService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/vets")
@RequiredArgsConstructor
@Slf4j
public class VeterianController {
    private final VeterianService veterianService;

    @GetMapping("")
    public ResponseEntity<List<VetetrianResponseDto>> showVeterians() {
        List<VetetrianResponseDto> vetResDtoList = veterianService.getAllVeterians();
        return ResponseEntity.status(HttpStatus.OK).body(vetResDtoList);
    }
}
