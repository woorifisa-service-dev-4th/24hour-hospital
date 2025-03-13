package dev.spring.petclinic.controller;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.dto.OwnerDto;
import dev.spring.petclinic.dto.OwnerListResponseDto;
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
    public String addOwner(@ModelAttribute("owner") OwnerDto ownerDto) {
        Owner savedOwner = ownerService.saveOwner(ownerDto.toEntity());
        return "redirect:/owners/" + savedOwner.getId();
    }

    @Operation(summary = "owner detail 조회")
    @Transactional
    @GetMapping("/{id}")
    public String getOwnerDetail(@PathVariable("id") Long ownerId, Model model) {
        Owner owner = ownerService.findOwnerWithPetsAndVisits(ownerId);
        model.addAttribute("owner", owner);
        return "owners/ownerDetails";
    }

//    @GetMapping(value = "/owners")
//    public String processFindForm(@RequestParam(defaultValue = "") String lastName, Pageable pageable, Model model) {
//        Page<Owner> ownersPage = ownerService.findByLastName(lastName, pageable);
//        if (ownersPage.isEmpty()) {
//            model.addAttribute("notFound", true);
//            return "owners/findOwners";
//        } else if (ownersPage.getTotalElements() == 1) {
//            Owner owner = ownersPage.getContent().get(0);
//            return "redirect:/owners/" + owner.getId();
//        } else {
//            model.addAttribute("selections", ownersPage.getContent());
//            return "owners/ownersList";
//        }
//    }
}
