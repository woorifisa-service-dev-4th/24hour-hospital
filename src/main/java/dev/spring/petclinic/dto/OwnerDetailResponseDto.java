package dev.spring.petclinic.dto;

import dev.spring.petclinic.domain.Owner;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OwnerDetailResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;

    public static OwnerDetailResponseDto from(Owner owner) {
        return OwnerDetailResponseDto.builder()
                .id(owner.getId())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .address(owner.getAddress())
                .city(owner.getCity())
                .telephone(owner.getCity())
                .build();
    }
}
