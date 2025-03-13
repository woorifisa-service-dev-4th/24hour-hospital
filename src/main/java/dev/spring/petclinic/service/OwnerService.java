package dev.spring.petclinic.service;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.dto.OwnerDetailResponseDto;
import dev.spring.petclinic.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Transactional
    public Owner findOwnerWithPetsAndVisits(Long ownerId) {
        return ownerRepository.findById(ownerId)
                .orElseThrow(() -> new NoSuchElementException("해당 ID의 소유자를 찾을 수 없습니다: " + ownerId));
    }

    public Page<Owner> findByLastName(String lastName, Pageable pageable) {
        return ownerRepository.findByLastNameContainingIgnoreCase(lastName, pageable);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Page<Owner> findPaginatedAllOwners(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return ownerRepository.findAll(pageable);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Page<Owner> findPaginatedByLastName(String lastName, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return ownerRepository.findByLastNameContainingIgnoreCase(lastName, pageable); // ✅ Pet 정보 포함
    }
}
