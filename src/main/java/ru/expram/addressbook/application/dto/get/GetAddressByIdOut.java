package ru.expram.addressbook.application.dto.get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.expram.addressbook.application.dto.AddressInfoDTO;

@Getter
@Builder
@AllArgsConstructor
public class GetAddressByIdOut {

    private final AddressInfoDTO addressInfo;
}
