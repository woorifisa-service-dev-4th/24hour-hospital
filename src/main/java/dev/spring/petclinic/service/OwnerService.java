package dev.spring.petclinic.service;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.dto.response.OwnerDetailResponseDto;
import dev.spring.petclinic.dto.response.OwnerListResponseDto;
import dev.spring.petclinic.dto.request.OwnerRequestDto;
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

    public List<OwnerListResponseDto> findByLastName(String lastName) {
        if (lastName != null) {
            List<Owner> ownerList = ownerRepository.findByLastNameContainingIgnoreCase(lastName);
            return ownerList.stream().map(OwnerListResponseDto::of).collect(Collectors.toList());
        } else {
            List<Owner> allOwnerList = ownerRepository.findAll();
            return allOwnerList.stream().map(OwnerListResponseDto::of).collect(Collectors.toList());
        }
    }

    public OwnerDetailResponseDto findOwnerWithPetsAndVisits(Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new NoSuchElementException("해당 ID의 소유자를 찾을 수 없습니다: " + ownerId));
        return OwnerDetailResponseDto.of(owner); // DTO로 변환하여 반환
    }
}
