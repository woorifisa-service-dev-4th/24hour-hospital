package dev.spring.petclinic.repository;

import dev.spring.petclinic.domain.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
    Optional<Owner> findById(Long id);

    List<Owner> findByLastNameContainingIgnoreCase(String lastName);

}
