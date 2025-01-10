package ru.expram.addressbook.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.expram.addressbook.application.repository.IAddressRepository;
import ru.expram.addressbook.domain.models.AddressInfo;
import ru.expram.addressbook.infrastructure.common.IMapper;
import ru.expram.addressbook.infrastructure.database.jpa.AddressDAO;
import ru.expram.addressbook.infrastructure.database.jpa.JpaMapper;
import ru.expram.addressbook.infrastructure.entities.AddressInfoEntity;

import java.util.List;
import java.util.Optional;

@Service
public class AddressRepository implements IAddressRepository {

    private final IMapper<AddressInfo, AddressInfoEntity> mapper;

    @Autowired
    private AddressDAO addressDAO;

    public AddressRepository() {
        this.mapper = new JpaMapper();
    }

    @Override
    public AddressInfo saveAddress(AddressInfo address) {
        AddressInfoEntity addressInfo
                = addressDAO.save(mapper.mapToEntity(address));

        return mapper.mapToModel(addressInfo);
    }

    @Override
    public Optional<AddressInfo> getAddressById(Long id) {
        Optional<AddressInfoEntity> addressInfo =
                addressDAO.findById(id);

        if(addressInfo.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(mapper.mapToModel(addressInfo.get()));
    }

    @Override
    public List<AddressInfo> getAllAddresses() {
        return addressDAO.findAll().stream().map(mapper::mapToModel).toList();
    }

    @Override
    public void deleteAddressById(Long id) {
        addressDAO.deleteById(id);
    }

    @Override
    public AddressInfo updateAddress(Long id, AddressInfo address) {
        address.setId(id);

        addressDAO.save(mapper.mapToEntity(address));
        return address;
    }

    @Override
    public boolean existsById(Long id) {
        return addressDAO.existsById(id);
    }
}
