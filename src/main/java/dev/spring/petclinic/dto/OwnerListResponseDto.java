package dev.spring.petclinic.dto;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.domain.Pet;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnerListResponseDto {
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;
    private List<PetResponseDto> pets;

    public static OwnerListResponseDto of(Owner owner) {
        return OwnerListResponseDto.builder()
                .id(owner.getId())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .address(owner.getAddress())
                .city(owner.getCity())
                .telephone(owner.getTelephone())
                .pets(owner.getPets().stream().map(PetResponseDto::of).collect(Collectors.toList()))
                .build();
    }
}
