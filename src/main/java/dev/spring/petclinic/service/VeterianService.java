package dev.spring.petclinic.service;

import dev.spring.petclinic.domain.Vets;
import dev.spring.petclinic.dto.response.VetetrianResponseDto;
import dev.spring.petclinic.repository.VetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VeterianService {
    private final VetsRepository vetsRepository;
    public List<VetetrianResponseDto> getAllVeterians() {
        List<Vets> vetsList = vetsRepository.findAll();

        List<VetetrianResponseDto> vetetrianResDtoList = vetsList.stream().map(
                vets -> {
                    return VetetrianResponseDto.builder()
                            .id(vets.getId())
                            .firstName(vets.getFirstName())
                            .lastName(vets.getLastName())
                            .specialist(vets.getSpecialist())
                            .build();
                }
        ).collect(Collectors.toList());

        return vetetrianResDtoList;
    }
}
