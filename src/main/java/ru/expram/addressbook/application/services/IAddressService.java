package ru.expram.addressbook.application.services;

import ru.expram.addressbook.application.dto.AddressInfoDTO;
import ru.expram.addressbook.application.dto.delete.DeleteAddressByIdIn;
import ru.expram.addressbook.application.dto.get.GetAddressByIdIn;
import ru.expram.addressbook.application.dto.get.GetAddressByIdOut;
import ru.expram.addressbook.application.dto.post.AddAddressOut;
import ru.expram.addressbook.application.dto.put.UpdateAddressByIdIn;
import ru.expram.addressbook.application.dto.put.UpdateAddressByIdOut;

public interface IAddressService {

    AddAddressOut addAddress(AddressInfoDTO addAddressIn);
    GetAddressByIdOut getAddressById(GetAddressByIdIn getAddressByIdIn);
    UpdateAddressByIdOut  updateAddressById(UpdateAddressByIdIn updateAddressByIdIn);
    void deleteAddressById(DeleteAddressByIdIn deleteAddressByIdIn);
}
