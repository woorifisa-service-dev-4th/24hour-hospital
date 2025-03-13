package dev.spring.petclinic.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "visits")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String description;

    @Builder
    public Visit(Pet pet, LocalDate date, String description) {
        this.pet = pet;
        this.date = date;
        this.description = description;
    }

    public static Visit of(Pet pet, LocalDate date, String description) {
        return Visit.builder()
                .pet(pet)
                .date(date)
                .description(description)
                .build();
    }
}
