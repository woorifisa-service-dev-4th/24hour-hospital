package dev.spring.petclinic.service;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerService {
  private final OwnerRepository ownerRepository;

  public Owner saveOwner(Owner owner) {
    ownerRepository.save(owner);
    return owner;
  }

  public Owner findById(long ownerId) {
    return ownerRepository.findById(ownerId).orElse(null);
  }

  public Page<Owner> findByLastName(String lastName, Pageable pageable) {
    return ownerRepository.findByLastNameContainingIgnoreCase(lastName, pageable);
  }

  public Page<Owner> findAll(Pageable pageable) {
    return ownerRepository.findAll(pageable);
  }
}