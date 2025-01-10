package ru.expram.addressbook.application.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.expram.addressbook.application.common.IDTOMapper;
import ru.expram.addressbook.application.dto.AddressDTO;
import ru.expram.addressbook.application.dto.AddressInfoDTO;
import ru.expram.addressbook.domain.models.AddressInfo;
import ru.expram.addressbook.domain.valueobjects.Address;
import ru.expram.addressbook.domain.valueobjects.Name;

@Component
public class DTOAddressInfoMapper implements IDTOMapper<AddressInfo, AddressInfoDTO> {

    @Autowired
    private IDTOMapper<Address, AddressDTO> addressDTOMapper;

    @Override
    public AddressInfo mapToModel(AddressInfoDTO addressInfoDTO) {
        Name name = new Name(addressInfoDTO.getFirstName(), addressInfoDTO.getLastName());

        return AddressInfo.builder()
                .name(name)
                .address(addressDTOMapper.mapToModel(addressInfoDTO.getAddress()))
                .build();
    }

    @Override
    public AddressInfoDTO mapToDto(AddressInfo addressInfo) {
        return AddressInfoDTO.builder()
                .firstName(addressInfo.getName().getFirstName())
                .lastName(addressInfo.getName().getLastName())
                .address(addressDTOMapper.mapToDto(addressInfo.getAddress()))
                .build();
    }
}
