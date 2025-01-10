package ru.expram.addressbook.application.dto.put;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.expram.addressbook.application.dto.AddressInfoDTO;

@Getter
@Builder
@AllArgsConstructor
public class UpdateAddressByIdOut {

    private final AddressInfoDTO addressInfo;
}
