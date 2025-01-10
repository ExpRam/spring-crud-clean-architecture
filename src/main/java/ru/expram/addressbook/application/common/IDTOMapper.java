package ru.expram.addressbook.application.common;

public interface IDTOMapper<T, U> {

    T mapToModel(U u);
    U mapToDto(T t);

}
