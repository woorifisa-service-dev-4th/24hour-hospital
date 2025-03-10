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
}
