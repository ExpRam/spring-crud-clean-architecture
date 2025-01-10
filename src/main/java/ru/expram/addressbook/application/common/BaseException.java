package ru.expram.addressbook.application.common;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final String exceptionName;
    private final String exceptionMessage;
    private final int errorCode;

    public BaseException(String message, int errorCode) {
        super(message);
        this.exceptionName = this.getClass().getSimpleName();
        this.exceptionMessage = message;
        this.errorCode = errorCode;
    }
}
