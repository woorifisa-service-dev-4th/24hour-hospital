package dev.spring.petclinic.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder
    public Type(String name) {
        this.name = name;
    }

    public static Type of(String name) {
        return Type.builder().name(name).build();
    }
}
