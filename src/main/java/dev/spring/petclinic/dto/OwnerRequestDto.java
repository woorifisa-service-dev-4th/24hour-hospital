package dev.spring.petclinic.dto;

import dev.spring.petclinic.domain.Owner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerRequestDto {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;
}
