package ru.expram.addressbook.application.dto.put;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.expram.addressbook.application.dto.AddressInfoDTO;

@Getter
@Builder
@AllArgsConstructor
public class UpdateAddressByIdIn {

    @NotNull(message = "Cannot process request, because id is null!")
    private final Long id;

    @Valid
    @NotNull(message = "Cannot process request, because addressInfo is null!")
    private final AddressInfoDTO addressInfo;
}
