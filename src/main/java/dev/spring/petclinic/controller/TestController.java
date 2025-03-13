package dev.spring.petclinic.controller;

import dev.spring.petclinic.dto.TestDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Operation(summary = "Test GET endpoint", description = "테스트 API입니다.")
    @GetMapping("/test")
    public TestDTO test() {
        return new TestDTO("Hello, this is a test message!", "success");
    }
}
