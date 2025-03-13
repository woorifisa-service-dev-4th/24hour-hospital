package dev.spring.petclinic.domain;

import jakarta.persistence.*;
import lombok.*;

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

    @Override
    public String toString() {
        return name;  // 또는 원하는 다른 필드 출력
    }
}
