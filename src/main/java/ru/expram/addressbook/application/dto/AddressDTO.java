package ru.expram.addressbook.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AddressDTO {

    @NotNull(message = "Country name cannot be null or empty!")
    private String country;

    @NotNull(message = "City name cannot be null or empty!")
    private String city;

    @NotNull(message = "ZipCode cannot be null!")
    private Integer zipCode;

    @NotNull(message = "Street name cannot be null or empty!")
    private String street;

    @NotNull(message = "Street Number cannot be null!")
    private Integer streetNumber;

    @NotNull(message = "Apartment number cannot be null!")
    private Integer apartmentNumber;

}
