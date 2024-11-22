package com.vti.service;

import com.vti.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAddressService {

    public List<Address> getAllAddresses();

    Page<Address> getAllAddresses(Pageable pageable);

    public Address getAddressById(short id);

    public Address getAddressByName(String name);

    public void createAddress(String name);

    public void updateAddress(String name);

    public void deleteAddress(String name);

    public boolean isAddressExistId(short id);

    public boolean isAddressExistName(String name);

}
