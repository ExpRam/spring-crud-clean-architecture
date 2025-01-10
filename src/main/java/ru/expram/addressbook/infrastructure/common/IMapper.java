package ru.expram.addressbook.infrastructure.common;

public interface IMapper<T, U> {

    T mapToModel(U u);
    U mapToEntity(T t);
}
