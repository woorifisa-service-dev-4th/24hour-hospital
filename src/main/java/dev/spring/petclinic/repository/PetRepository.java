package dev.spring.petclinic.repository;

import dev.spring.petclinic.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends  JpaRepository<Pet,Long> {
}
