package ru.expram.addressbook.presentation.exceptions;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class BaseListedSpringException {

    private ZonedDateTime timestamp;
    private int status;
    private List<String> errors;
    private String path;

    public BaseListedSpringException(int status, List<String> errors, String path) {
        this.timestamp = ZonedDateTime.now();
        this.status = status;
        this.errors = errors;
        this.path = path;
    }
}
