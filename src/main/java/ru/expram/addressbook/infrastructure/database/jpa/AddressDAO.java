package ru.expram.addressbook.infrastructure.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.expram.addressbook.infrastructure.entities.AddressInfoEntity;

@Repository
public interface AddressDAO extends JpaRepository<AddressInfoEntity, Long> { }
