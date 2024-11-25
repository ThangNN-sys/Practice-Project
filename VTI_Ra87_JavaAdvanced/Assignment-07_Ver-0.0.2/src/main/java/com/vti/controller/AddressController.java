package com.vti.controller;

import com.vti.entity.Address;
import com.vti.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/addresses")
public class AddressController {

    @Autowired
    private IAddressService service;

    // get all paging
    @GetMapping()
    public Page<Address> getAllAddresses(Pageable pageable) {
        return service.getAllAddresses(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public Address getAddressById(@PathVariable(name = "id") short id) {
        return service.getAddressById(id);
    }

    // get by name
    @GetMapping(value = "/name/{name}")
    public Address getAddressByName(@PathVariable(name = "name") String name) {
        return service.getAddressByName(name);
    }

    // create new
    @PostMapping()
    public void createAddress(@RequestBody Address address) {
        service.createAddress(address);
    }

    // update name find by id
    @PutMapping(value = "/{id}")
    public void updateAddress(@PathVariable(name = "id") short id, @RequestBody Address address) {
        address.setId(id);
        service.updateAddress(address);
    }

    // update by object
    @PutMapping
    public ResponseEntity<String> updateAddress1(@RequestBody Address address) {
        try {
            updateAddress1(address);
            return ResponseEntity.ok("Address updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Failed to update address: " + e.getMessage());
        }
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteAddress(@PathVariable(name = "id") short id) {
        service.deleteAddress(id);
    }

    // exists by id
    @GetMapping(value = "/is-exist-id/{id}")
    public boolean isAddressExistId(@PathVariable(name = "id") short id) {
        return service.isAddressExistId(id);
    }

    // exists by name
    @GetMapping(value = "/is-exist-name/{name}")
    public boolean isAddressExistName(@PathVariable(name = "name") String name) {
        return service.isAddressExistName(name);
    }

}
