package ru.expram.addressbook.application.exceptions;

import ru.expram.addressbook.application.common.BaseException;

public class AddressNotFoundException extends BaseException {

    private static final int NOT_FOUND = 404;

    public AddressNotFoundException(String message) {
        super(message, NOT_FOUND);
    }
}
