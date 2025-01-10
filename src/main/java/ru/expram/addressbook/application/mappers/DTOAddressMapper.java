package ru.expram.addressbook.application.mappers;

import org.springframework.stereotype.Component;
import ru.expram.addressbook.application.dto.AddressDTO;
import ru.expram.addressbook.domain.valueobjects.Address;
import ru.expram.addressbook.application.common.IDTOMapper;

@Component
public class DTOAddressMapper implements IDTOMapper<Address, AddressDTO> {

    @Override
    public Address mapToModel(AddressDTO addressDTO) {
        return Address.builder()
                .country(addressDTO.getCountry())
                .city(addressDTO.getCity())
                .street(addressDTO.getStreet())
                .zipCode(addressDTO.getZipCode())
                .streetNumber(addressDTO.getStreetNumber())
                .apartmentNumber(addressDTO.getApartmentNumber()).build();
    }

    @Override
    public AddressDTO mapToDto(Address address) {
        return AddressDTO.builder()
                .country(address.getCountry())
                .city(address.getCity())
                .street(address.getStreet())
                .zipCode(address.getZipCode())
                .streetNumber(address.getStreetNumber())
                .apartmentNumber(address.getApartmentNumber()).build();
    }
}
