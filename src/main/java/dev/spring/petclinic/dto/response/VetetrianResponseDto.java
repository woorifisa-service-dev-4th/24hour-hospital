package dev.spring.petclinic.dto.response;

import dev.spring.petclinic.domain.Vets;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VetetrianResponseDto {
    private long id;

    private String firstName;

    private String lastName;

    private String specialist;

    public static VetetrianResponseDto of(Vets vets) {
        return VetetrianResponseDto.builder()
                .id(vets.getId())
                .firstName(vets.getFirstName())
                .lastName(vets.getLastName())
                .specialist(vets.getSpecialist())
                .build();
    }
}
