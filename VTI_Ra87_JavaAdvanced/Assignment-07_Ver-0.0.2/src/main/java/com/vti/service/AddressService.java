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

    @Autowired
    private IAddressRepository repository;


    @Override
    public List<Address> getAllAddresses() {
        return List.of();
    }

    @Override
    public Page<Address> getAllAddresses(Pageable pageable) {
        return null;
    }

    @Override
    public Address getAddressById(short id) {
        return null;
    }

    @Override
    public Address getAddressByName(String name) {
        return null;
    }

    @Override
    public void createAddress(String name) {

    }

    @Override
    public void updateAddress(String name) {

    }

    @Override
    public void deleteAddress(String name) {

    }

    @Override
    public boolean isAddressExistId(short id) {
        return false;
    }

    @Override
    public boolean isAddressExistName(String name) {
        return false;
    }
}
