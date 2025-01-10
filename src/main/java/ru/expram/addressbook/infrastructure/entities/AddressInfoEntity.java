package ru.expram.addressbook.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="addresses")
public class AddressInfoEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Integer zipCode;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private Integer streetNumber;

    @Column(nullable = false)
    private Integer apartmentNumber;
}
