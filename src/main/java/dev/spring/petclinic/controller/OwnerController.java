package dev.spring.petclinic.controller;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.dto.response.OwnerDetailResponseDto;
import dev.spring.petclinic.dto.response.OwnerListResponseDto;
import dev.spring.petclinic.dto.request.OwnerRequestDto;
import dev.spring.petclinic.service.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    @GetMapping("/{id}")
    public ResponseEntity<OwnerDetailResponseDto> getOwnerDetail(@PathVariable("id") Long ownerId) {
        OwnerDetailResponseDto ownerDetail = ownerService.findOwnerWithPetsAndVisits(ownerId);
        return ResponseEntity.status(HttpStatus.OK).body(ownerDetail);
    }

}
