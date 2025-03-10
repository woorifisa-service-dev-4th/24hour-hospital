package dev.spring.petclinic.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String address;

    private String city;

    private String telephone;

    @Builder
    private Owner(String firstName, String lastName, String address, String city, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    public static Owner of(String firstName, String lastName, String address, String city, String telephone) {
        return Owner.builder()
          .firstName(firstName)
          .lastName(lastName)
          .address(address)
          .city(city)
          .telephone(telephone).build();
    }
}