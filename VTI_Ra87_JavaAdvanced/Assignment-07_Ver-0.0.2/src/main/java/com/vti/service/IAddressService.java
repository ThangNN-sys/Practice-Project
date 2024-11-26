package com.vti.service;

import com.vti.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IAddressService {

    List<Address> getAllAddresses();

    Page<Address> getAllAddresses(Pageable pageable);

    Optional<Address> getAddressById(short id);

    Address getAddressByName(String name);

    void createAddress(Address address);

    void updateAddress1(short id, String newName);

    void updateAddress2(Address address);

    void deleteAddress(short id);

    boolean isAddressExistId(short id);

    boolean isAddressExistName(String name);

}
