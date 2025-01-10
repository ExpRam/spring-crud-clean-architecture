package ru.expram.addressbook.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.expram.addressbook.application.dto.AddressInfoDTO;
import ru.expram.addressbook.application.dto.delete.DeleteAddressByIdIn;
import ru.expram.addressbook.application.dto.get.GetAddressByIdIn;
import ru.expram.addressbook.application.dto.get.GetAddressByIdOut;
import ru.expram.addressbook.application.dto.post.AddAddressOut;
import ru.expram.addressbook.application.dto.put.UpdateAddressByIdIn;
import ru.expram.addressbook.application.dto.put.UpdateAddressByIdOut;
import ru.expram.addressbook.application.services.IAddressService;

@RestController
@RequestMapping("api/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressService addressService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AddAddressOut addAddress(@Validated @RequestBody AddressInfoDTO in) {
        return addressService.addAddress(in);
    }

    @GetMapping
    GetAddressByIdOut getAddressById(@Validated @RequestBody GetAddressByIdIn in) {
        return addressService.getAddressById(in);
    }

    @DeleteMapping
    void deleteQAddressById(@Validated @RequestBody DeleteAddressByIdIn in) {
        addressService.deleteAddressById(in);
    }

    @PutMapping
    UpdateAddressByIdOut updateAddressById(@Validated @RequestBody UpdateAddressByIdIn in) {
        return addressService.updateAddressById(in);
    }
}
