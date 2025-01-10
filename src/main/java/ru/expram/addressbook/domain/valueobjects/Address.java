package ru.expram.addressbook.domain.valueobjects;

import lombok.Builder;
import lombok.Getter;
import ru.expram.addressbook.domain.common.ValueObject;

@Getter
@Builder
public class Address implements ValueObject {

    private String country;
    private String city;
    private int zipCode;
    private String street;
    private int streetNumber;
    private int apartmentNumber;

    public Address(String country, String city, int zipCode, String street, int streetNumber, int apartmentNumber) {
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        validate();
    }

    @Override
    public void validate() {
        // Some validation could be added here...
    }
}
