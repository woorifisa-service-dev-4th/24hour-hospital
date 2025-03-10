package dev.spring.petclinic.repository;
import dev.spring.petclinic.domain.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
    Page<Owner> findByLastNameContainingIgnoreCase(String lastName, Pageable pageable);
}