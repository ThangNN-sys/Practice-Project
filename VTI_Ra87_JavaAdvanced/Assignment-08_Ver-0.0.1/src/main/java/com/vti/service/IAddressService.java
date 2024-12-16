package com.vti.service;

import com.vti.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAddressService {

    List<Address> getAllAddresses();

    Page<Address> getAllAddressesPaging(Pageable pageable);

    Address getAddressById(short id);

    Address getAddressByName(String name);

    void createAddress(Address address);

    void updateAddress1(short id, String newName);

    void updateAddress2(Address address);

    void deleteAddress(short id);

    boolean isAddressExistsId(short id);

    boolean isAddressExistsName(String name);

}
