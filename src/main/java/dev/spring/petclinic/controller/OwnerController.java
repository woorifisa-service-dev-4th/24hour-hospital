package dev.spring.petclinic.controller;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.dto.OwnerDto;
import dev.spring.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
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
      @GetMapping("/find")
      public String showFindOwnerForm(Model model) {
          model.addAttribute("owner", new OwnerDto());
          return "owners/findOwners";
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
}
