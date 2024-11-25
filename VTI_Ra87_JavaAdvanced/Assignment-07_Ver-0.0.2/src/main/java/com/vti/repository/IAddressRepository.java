package com.vti.repository;

import com.vti.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Address, Short> {

    Address findById(short id);

    Address findByName(String name);

    @Query("SELECT a FROM Address a")
    List<Address> findAll();

    @Query("SELECT a FROM Address a WHERE a.id = :idParam")
    Address findAddressById(@Param("idParam") short id);

    @Query("SELECT a FROM Address a WHERE a.name = :nameParam")
    Address findAddressByName(@Param("nameParam") String name);

    @Modifying
    @Query("UPDATE Address a SET a.name = :nameParam WHERE a.id = :idParam")
    void updateAddress(@Param("idParam") short id, @Param("nameParam") String name);

    @Modifying
    @Query("DELETE FROM Address a WHERE a.id = :idParam")
    void deleteAddress(@Param("idParam") short id);
}
