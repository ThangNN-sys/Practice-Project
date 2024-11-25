package com.vti.service;

import com.vti.entity.Address;
import com.vti.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private IAddressRepository repository;

    @Override
    public Page<Address> getAllAddresses(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Address getAddressById(short id) {
        return repository.findAddressById(id);
    }

    @Override
    public Address getAddressByName(String name) {
        return repository.findAddressByName(name);
    }

    @Override
    public void createAddress(Address address) {
        repository.save(address);
    }

    @Override
    public void updateAddress(short id, String newName) {
        Address address = new Address(id, newName);
        repository.save(address);
    }

    @Override
    public void updateAddress(Address address) {
        repository.save(address);
    }

    @Override
    public void deleteAddress(short id) {
        repository.deleteById(id);
    }

    @Override
    public boolean isAddressExistId(short id) {
        return repository.existsById(id);
    }

    @Override
    public boolean isAddressExistName(String name) {
        Address address = repository.findAddressByName(name);
        return address != null;
        // return repository.findAddressByName(name) != null; // cách viết ngắn gọn
    }

}
