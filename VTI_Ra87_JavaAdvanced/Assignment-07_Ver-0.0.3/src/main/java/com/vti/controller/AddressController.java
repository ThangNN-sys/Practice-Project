package com.vti.controller;

import com.vti.entity.Address;
import com.vti.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/addresses")
public class AddressController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: Address
     */

    @Autowired
    private IAddressService service;

    // get all list
//    @GetMapping()
//    public List<Address> getListAddress() {
//        return service.getListAddresses();
//    }

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
    public void createAddress(@RequestBody Address create) {
        service.createAddress(create);
    }

    // update name find by id
    @PutMapping(value = "/u1/{id}")
    public void updateAddress1(@PathVariable(name = "id") short id, @RequestBody Address address) {
        address.setId(id);
        service.updateAddress1(id, address.getName());
    }

    // update by object
    @PutMapping(value = "/u2")
    public void updateAddress2(@RequestBody Address address) {
        service.updateAddress2(address);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteAddress(@PathVariable(name = "id") short id) {
        service.deleteAddress(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isAddressExistId(@PathVariable(name = "id") short id) {
        return service.isAddressExistId(id);
    }

    // exists by name
    @GetMapping(value = "/exists-name/{name}")
    public boolean isAddressExistName(@PathVariable(name = "name") String name) {
        return service.isAddressExistName(name);
    }

}
