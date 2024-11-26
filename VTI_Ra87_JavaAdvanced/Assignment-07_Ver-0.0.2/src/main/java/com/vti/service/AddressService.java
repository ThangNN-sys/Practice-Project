package com.vti.service;

import com.vti.entity.Address;
import com.vti.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: Address
     */

    @Autowired
    private IAddressRepository repository;

    // get all
    @Override
    public List<Address> getListAddresses() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<Address> getAllAddresses(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public Address getAddressById(short id) {
        return repository.findAddressById(id);
    }

    // get by name with @Query
    @Override
    public Address getAddressByName(String name) {
        return repository.findAddressByName(name);
    }

    // create new
    @Override
    public void createAddress(Address address) {
        repository.save(address);
    }

    // update name find by id
    @Override
    public void updateAddress1(short id, String newName) {
        repository.updateAddress1(id, newName);
    }

    // update by object
    @Override
    public void updateAddress2(Address address) {
        repository.save(address);
    }

    // delete by id
    @Override
    public void deleteAddress(short id) {
        repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isAddressExistId(short id) {
        return repository.existsById(id);
    }

    // exists by name
    @Override
    public boolean isAddressExistName(String name) {
        Address address = repository.findAddressByName(name);
        return address != null;
        // return repository.findAddressByName(name) != null; // cách viết ngắn gọn
    }

}
