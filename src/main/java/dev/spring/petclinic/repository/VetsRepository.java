package dev.spring.petclinic.repository;


import dev.spring.petclinic.domain.Vets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetsRepository extends JpaRepository<Vets, Long> {
}
