package ru.expram.addressbook.domain.valueobjects;

import lombok.Getter;
import ru.expram.addressbook.domain.common.ValueObject;

@Getter
public class Name implements ValueObject {

    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        validate();
    }

    @Override
    public void validate() {
        // Some validation could be added here...
    }
}
