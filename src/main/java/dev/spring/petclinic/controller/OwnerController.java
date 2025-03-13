package dev.spring.petclinic.controller;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.dto.OwnerDto;
import dev.spring.petclinic.service.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    // /owners/find 경로에 대한 html 폼 템플릿 반환
    @Operation(summary = "검색")
    @GetMapping("/find")
    public String showFindOwnerForm(Model model) {
        model.addAttribute("owner", new OwnerDto());
        return "owners/findOwners";
    }

    @GetMapping
    public String findOwners(@RequestParam(value = "lastName", required = false) String lastName,
                             @RequestParam(value = "page", defaultValue = "1") int page,
                             Model model) {

        if (!model.containsAttribute("owner")) {
            model.addAttribute("owner", new OwnerDto());
        }

        int pageSize = 5;
        Page<Owner> ownerPage = (lastName == null || lastName.isEmpty())
                ? ownerService.findPaginatedAllOwners(page, pageSize)
                : ownerService.findPaginatedByLastName(lastName, page, pageSize);

        if (ownerPage.isEmpty()) {
            model.addAttribute("errorMessage", "No owners found with last name: " + lastName);
            return "owners/findOwners";
        }

        model.addAttribute("listOwners", ownerPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", ownerPage.getTotalPages());

        return "owners/ownersList";
    }

    // /owners/new 경로에 대한 html 폼 템플릿 반환
    @GetMapping("/new")
    public String showCreateOwnerForm(Model model) {
        OwnerDto ownerDto = OwnerDto.builder().isNew(true).build();
        model.addAttribute("owner", ownerDto);
        return "owners/createOrUpdateOwnerForm";
    }

    // owner 추가
    @PostMapping("/new")
    public String addOwner(@ModelAttribute("owner") OwnerDto ownerDto) {
        Owner savedOwner = ownerService.saveOwner(ownerDto.toEntity());
        return "redirect:/owners/" + savedOwner.getId();
    }


    @Transactional
    @GetMapping("/{id}")
    public String getOwnerDetail(@PathVariable("id") Long ownerId, Model model) {
        Owner owner = ownerService.findOwnerWithPetsAndVisits(ownerId);
        model.addAttribute("owner", owner);
        return "owners/ownerDetails";
    }

    @GetMapping(value = "/owners")
    public String processFindForm(@RequestParam(defaultValue = "") String lastName, Pageable pageable, Model model) {
        Page<Owner> ownersPage = ownerService.findByLastName(lastName, pageable);
        if (ownersPage.isEmpty()) {
            model.addAttribute("notFound", true);
            return "owners/findOwners";
        } else if (ownersPage.getTotalElements() == 1) {
            Owner owner = ownersPage.getContent().get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", ownersPage.getContent());
            return "owners/ownersList";
        }
    }
}
