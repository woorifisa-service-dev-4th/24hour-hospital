package dev.spring.petclinic.service;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.dto.OwnerListResponseDto;
import dev.spring.petclinic.dto.OwnerRequestDto;
import dev.spring.petclinic.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public Long saveOwner(OwnerRequestDto ownerReqDto) {
        Owner owner = Owner.builder()
                .firstName(ownerReqDto.getFirstName())
                .lastName(ownerReqDto.getLastName())
                .address(ownerReqDto.getAddress())
                .city(ownerReqDto.getCity())
                .telephone(ownerReqDto.getCity())
                .build();

        Owner newOwner = ownerRepository.save(owner);
        return newOwner.getId();
    }

    @Transactional
    public Owner findOwnerWithPetsAndVisits(Long ownerId) {
        return ownerRepository.findById(ownerId)
                .orElseThrow(() -> new NoSuchElementException("해당 ID의 소유자를 찾을 수 없습니다: " + ownerId));
    }

    public List<OwnerListResponseDto> findByLastName(String lastName) {
        List<Owner> ownerList = ownerRepository.findByLastNameContainingIgnoreCase(lastName);
        return ownerList.stream().map(OwnerListResponseDto::of).collect(Collectors.toList());
    }


//    @org.springframework.transaction.annotation.Transactional(readOnly = true)
//    public Page<Owner> findPaginatedAllOwners(int page, int size) {
//        Pageable pageable = PageRequest.of(page - 1, size);
//        return ownerRepository.findAll(pageable);
//    }
//
//    @org.springframework.transaction.annotation.Transactional(readOnly = true)
//    public Page<Owner> findPaginatedByLastName(String lastName, int page, int size) {
//        Pageable pageable = PageRequest.of(page - 1, size);
//        return ownerRepository.findByLastNameContainingIgnoreCase(lastName, pageable); // ✅ Pet 정보 포함
//    }
}
