package dev.spring.petclinic.service;

import dev.spring.petclinic.domain.Vets;
import dev.spring.petclinic.repository.VetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterianService {
    private final VetsRepository vetsRepository;
    public List<Vets> getAllVeterians() {
        System.out.println(vetsRepository.findById(1L));
        return vetsRepository.findAll();
    }
}
