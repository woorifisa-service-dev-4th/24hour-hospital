package dev.spring.petclinic.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String specialist;

    @Builder
    private Vets(String firstName, String lastName, String specialist) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialist = specialist;
    }

    public static Vets of(String firstName,String lastName, String specialist) {
        return Vets.builder().firstName(firstName).lastName(lastName).specialist(specialist).build();
    }
}
