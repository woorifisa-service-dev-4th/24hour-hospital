package dev.spring.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository implements JpaRepository<Pet,Long> {
}
