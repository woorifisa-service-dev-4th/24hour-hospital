package dev.spring.petclinic.dto.response;

import dev.spring.petclinic.domain.Owner;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class OwnerDetailResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;
    private List<PetResponseDto> pets;

    public static OwnerDetailResponseDto of(Owner owner) {
        return OwnerDetailResponseDto.builder()
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
