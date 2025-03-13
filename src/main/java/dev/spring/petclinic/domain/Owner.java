package dev.spring.petclinic.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners", indexes = {
        @Index(name = "idx_last_name", columnList = "last_name")
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(length = 255)
    private String address;

    @Column(length = 80)
    private String city;

    @Column(length = 20)
    private String telephone;

    @Setter
    @Getter
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Pet> pets;

    @Builder
    private Owner(String firstName, String lastName, String address, String city, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = new ArrayList<>();
    }

    public static Owner of(String firstName, String lastName, String address, String city, String telephone) {
        return Owner.builder()
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .city(city)
                .telephone(telephone)
                .build();
    }
}