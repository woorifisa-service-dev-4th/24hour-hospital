package dev.spring.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository implements JpaRepository<Owner,Long> {
}
