package ru.expram.addressbook.application.dto.delete;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DeleteAddressByIdIn {

    @NotNull(message = "Cannot process request, because id is null!")
    private final Long id;
}
