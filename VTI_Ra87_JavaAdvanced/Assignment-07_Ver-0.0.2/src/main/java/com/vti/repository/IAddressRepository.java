package com.vti.repository;

import com.vti.entity.Address;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Address, Short> {
    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: Address
     */

    @Query("SELECT a FROM Address a")
    List<Address> findAll();

    @Query("SELECT a FROM Address a WHERE a.addressId = :idParam")
    Address findAddressById(@Param("idParam") short id);

    @Query("SELECT a FROM Address a WHERE a.addressName = :nameParam")
    Address findAddressByName(@Param("nameParam") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Address a SET a.addressName = :nameParam WHERE a.addressId = :idParam")
    void updateAddress1(@Param("idParam") short id, @Param("nameParam") String name);

}
