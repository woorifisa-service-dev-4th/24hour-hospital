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
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String telephone;


    @Builder
    private Owner(String firstname, String lastname, String address, String city, String telephone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    public static Owner of(String firstname, String lastname, String address, String city, String telephone) {
        return Owner.builder()
                .firstname(firstname)
                .lastname(lastname)
                .address(address)
                .city(city)
                .telephone(telephone).build();
    }
}
