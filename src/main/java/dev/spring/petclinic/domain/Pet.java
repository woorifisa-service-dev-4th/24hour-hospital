package dev.spring.petclinic.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Getter
    @Setter
    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER)
    private List<Visit> visits;


    @Builder
    public Pet(String name, LocalDate birthDate, Type type, Owner owner) {
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.owner = owner;
        this.visits = new ArrayList<>();
    }

    public static Pet of(String name, LocalDate birthDate, Type type, Owner owner) {
        return Pet.builder()
                .name(name)
                .birthDate(birthDate)
                .type(type)
                .owner(owner)
                .build();
    }

    @Override
    public String toString() {
        return "Pet{name='" + name + "', birthDate=" + birthDate + ", type=" + type + "}";
    }
}
