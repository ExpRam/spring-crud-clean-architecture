package ru.expram.addressbook.presentation.exceptions;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class BaseSpringException {

    private ZonedDateTime timestamp;
    private int status;
    private String error;
    private String path;

    public BaseSpringException(int status, String error, String path) {
        this.timestamp = ZonedDateTime.now();
        this.status = status;
        this.error = error;
        this.path = path;
    }
}
