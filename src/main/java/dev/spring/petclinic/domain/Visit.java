package dev.spring.petclinic.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "visits")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate visitDate;

    private String description;

    @Builder
    public Visit(Pet pet, LocalDate visitDate, String description) {
        this.pet = pet;
        this.visitDate = visitDate;
        this.description = description;
    }

    public static Visit of(Pet pet, LocalDate visitDate, String description) {
        return Visit.builder()
                .pet(pet)
                .visitDate(visitDate)
                .description(description)
                .build();
    }
}
