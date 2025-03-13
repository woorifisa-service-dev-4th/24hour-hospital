package dev.spring.petclinic.controller;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.dto.OwnerDto;
import dev.spring.petclinic.dto.OwnerListResponseDto;
import dev.spring.petclinic.dto.OwnerRequestDto;
import dev.spring.petclinic.service.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/owners")
@RequiredArgsConstructor
@Tag(name = "Owner API")
public class OwnerController {

    private final OwnerService ownerService;

    @Operation(summary = "검색")
    @GetMapping("")
    public ResponseEntity<List<OwnerListResponseDto>> findOwners(@RequestParam(value = "lastName", required = false) String lastName) {
        List<OwnerListResponseDto> ownerListResDto = ownerService.findByLastName(lastName);
        return ResponseEntity.status(HttpStatus.OK).body(ownerListResDto);

    }

    // owner 추가
    @Operation(summary = "owner 추가")
    @PostMapping("/new")
    public ResponseEntity<?> addOwner(@RequestBody OwnerRequestDto ownerRequestDto) {
        Long userId = ownerService.saveOwner(ownerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userId);
    }

    @Operation(summary = "owner detail 조회")
    @Transactional
    @GetMapping("/{id}")
    public String getOwnerDetail(@PathVariable("id") Long ownerId, Model model) {
        Owner owner = ownerService.findOwnerWithPetsAndVisits(ownerId);
        model.addAttribute("owner", owner);
        return "owners/ownerDetails";
    }
}
