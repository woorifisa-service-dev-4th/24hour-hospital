package dev.spring.petclinic.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @Builder
    private Owner(String name) {
        this.name = name;
    }

    public static Owner of(String name) {
        return Owner.builder().name(name).build();
    }
}
