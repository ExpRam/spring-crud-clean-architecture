package ru.expram.addressbook.infrastructure.database.jpa;

import ru.expram.addressbook.domain.models.AddressInfo;
import ru.expram.addressbook.domain.valueobjects.Address;
import ru.expram.addressbook.domain.valueobjects.Name;
import ru.expram.addressbook.infrastructure.common.IMapper;
import ru.expram.addressbook.infrastructure.entities.AddressInfoEntity;

public class JpaMapper implements IMapper<AddressInfo, AddressInfoEntity> {

    @Override
    public AddressInfo mapToModel(AddressInfoEntity addressInfo) {
        if(addressInfo == null) return null;

        Address addressVo = new Address(
                addressInfo.getCountry(),
                addressInfo.getCity(),
                addressInfo.getZipCode(),
                addressInfo.getStreet(),
                addressInfo.getStreetNumber(),
                addressInfo.getApartmentNumber()
        );

        Name nameVo = new Name(addressInfo.getFirstName(), addressInfo.getLastName());

        return AddressInfo.builder()
                .id(addressInfo.getId())
                .name(nameVo)
                .address(addressVo).build();
    }

    @Override
    public AddressInfoEntity mapToEntity(AddressInfo addressInfo) {
        if(addressInfo == null) return null;

        Name nameVo = addressInfo.getName();
        Address addressVo = addressInfo.getAddress();

        return AddressInfoEntity.builder()
                .id(addressInfo.getId())
                .firstName(nameVo.getFirstName())
                .lastName(nameVo.getLastName())
                .country(addressVo.getCountry())
                .city(addressVo.getCity())
                .zipCode(addressVo.getZipCode())
                .street(addressVo.getStreet())
                .streetNumber(addressVo.getStreetNumber())
                .apartmentNumber(addressVo.getApartmentNumber()).build();
    }
}
