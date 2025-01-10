package ru.expram.addressbook.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AddressInfoDTO {

    @NotNull(message = "First Name cannot be null or empty!")
    private final String firstName;

    @NotNull(message = "Last Name cannot be null or empty!")
    private final String lastName;

    @Valid
    @NotNull(message = "Address cannot be null!")
    private final AddressDTO address;
}
