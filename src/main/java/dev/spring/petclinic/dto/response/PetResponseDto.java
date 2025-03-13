package dev.spring.petclinic.dto.response;

import dev.spring.petclinic.domain.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class PetResponseDto {
    private long id;
    private String name;
    private String type;

    public static PetResponseDto of(Pet pet) {
        return PetResponseDto.builder()
                .id(pet.getId())
                .name(pet.getName())
                .type(pet.getType().getName()) // PetType 엔티티가 있다고 가정
                .build();
    }
}