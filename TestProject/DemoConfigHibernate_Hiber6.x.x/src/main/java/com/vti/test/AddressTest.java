package com.vti.test;

import com.vti.entity.Address;
import com.vti.repository.AddressRepository;

import java.util.List;

public class AddressTest {
    public static void main(String[] args) {
        AddressRepository repository = new AddressRepository();

        System.out.println("***********GET ALL***********");

        List<Address> Addresss = repository.getAllAddresses();

        for (Address address : Addresss) {
            System.out.println(address);
        }

        System.out.println("\n\n***********CREATE***********");
    }
}
