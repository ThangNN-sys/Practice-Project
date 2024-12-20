package com.vti.controller;

import com.vti.entity.Address;
import com.vti.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/addresss")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @GetMapping()
    public Page<Address> getAllAddresss(Pageable pageable) {
        return addressService.getAllAddresss(pageable);
    }

    @GetMapping(value = "/{id}")
    public Address getAddressById(@PathVariable(name = "id") short id) {
        return addressService.getAddressByID(id);
    }

    @GetMapping(value = "/name")
    public Address getAddressByName(@RequestParam(name = "name") String name) {
        return addressService.getAddressByName(name);
    }

    @PostMapping()
    public void createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
    }

    @PutMapping(value = "/{id}")
    public void updateAddress(@PathVariable(name = "id") short id, @RequestBody Address address) {
        address.setAddressId(id);
        addressService.updateAddress(address);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAddress(@PathVariable(name = "id") short id) {
        addressService.deleteAddress(id);
    }
}
