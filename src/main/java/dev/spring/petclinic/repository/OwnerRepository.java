package dev.spring.petclinic.repository;

import dev.spring.petclinic.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
