package ru.expram.addressbook.application.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.expram.addressbook.application.common.IDTOMapper;
import ru.expram.addressbook.application.dto.AddressInfoDTO;
import ru.expram.addressbook.application.dto.delete.DeleteAddressByIdIn;
import ru.expram.addressbook.application.dto.get.GetAddressByIdIn;
import ru.expram.addressbook.application.dto.get.GetAddressByIdOut;
import ru.expram.addressbook.application.dto.post.AddAddressOut;
import ru.expram.addressbook.application.dto.put.UpdateAddressByIdIn;
import ru.expram.addressbook.application.dto.put.UpdateAddressByIdOut;
import ru.expram.addressbook.application.exceptions.AddressNotFoundException;
import ru.expram.addressbook.application.repository.IAddressRepository;
import ru.expram.addressbook.application.services.IAddressService;
import ru.expram.addressbook.domain.models.AddressInfo;

import java.util.Optional;

@AllArgsConstructor
@Service // Ahhh... Spring dependency in application layer sounds bad :/
public class AddressService implements IAddressService {

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    private IDTOMapper<AddressInfo, AddressInfoDTO> addressInfoMapper;

    @Override
    public AddAddressOut addAddress(AddressInfoDTO addAddressIn) {
        AddressInfo addressInfo = addressInfoMapper.mapToModel(addAddressIn);

        addressInfo = addressRepository.saveAddress(addressInfo);
        return new AddAddressOut(addressInfo.getId());
    }

    @Override
    public GetAddressByIdOut getAddressById(GetAddressByIdIn getAddressByIdIn) {
        Optional<AddressInfo> optionalAddressInfo
                = addressRepository.getAddressById(getAddressByIdIn.getId());

        if(optionalAddressInfo.isEmpty())
            throw new AddressNotFoundException("Address with id " + getAddressByIdIn.getId() + " not found!");

        return new GetAddressByIdOut(addressInfoMapper.mapToDto(optionalAddressInfo.get()));
    }

    @Override
    public UpdateAddressByIdOut updateAddressById(UpdateAddressByIdIn updateAddressByIdIn) {
        if(!addressRepository.existsById(updateAddressByIdIn.getId()))
            throw new AddressNotFoundException("Address with id " + updateAddressByIdIn.getId() + " not found!");

        AddressInfo addressInfo
                = addressRepository.updateAddress(updateAddressByIdIn.getId(),
                addressInfoMapper.mapToModel(updateAddressByIdIn.getAddressInfo()));

        return new UpdateAddressByIdOut(addressInfoMapper.mapToDto(addressInfo));
    }

    @Override
    public void deleteAddressById(DeleteAddressByIdIn deleteAddressByIdIn) {
        if(!addressRepository.existsById(deleteAddressByIdIn.getId()))
            throw new AddressNotFoundException("Address with id " + deleteAddressByIdIn.getId() + " not found!");

        addressRepository.deleteAddressById(deleteAddressByIdIn.getId());
    }
}
