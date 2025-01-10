package ru.expram.addressbook.application.dto.get;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GetAddressByIdIn {

    @NotNull(message = "Cannot process request, because id is null!")
    private final Long id;
}
