package ru.expram.addressbook.application.repository;

import ru.expram.addressbook.domain.models.AddressInfo;

import java.util.List;
import java.util.Optional;

public interface IAddressRepository {

    AddressInfo saveAddress(AddressInfo address);
    Optional<AddressInfo> getAddressById(Long id);
    List<AddressInfo> getAllAddresses();
    void deleteAddressById(Long id);
    AddressInfo updateAddress(Long id, AddressInfo address);
    boolean existsById(Long id);
}
