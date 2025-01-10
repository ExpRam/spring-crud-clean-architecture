package ru.expram.addressbook.domain.models;

import lombok.*;
import ru.expram.addressbook.domain.common.Model;
import ru.expram.addressbook.domain.valueobjects.Address;
import ru.expram.addressbook.domain.valueobjects.Name;

@Builder
@Data
public class AddressInfo implements Model {

    private Long id;
    private Name name;
    private Address address;

    public AddressInfo(Long id, Name name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
        validate();
    }

    @Override
    public void validate() {
        // Some validation could be added here...
    }
}
