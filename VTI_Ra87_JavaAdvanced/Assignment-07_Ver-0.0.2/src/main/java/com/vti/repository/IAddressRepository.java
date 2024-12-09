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

    @Query("SELECT v FROM Address v")
    List<Address> findAll();

    @Query("SELECT v FROM Address v WHERE v.id = :idParam")
    Address findAddressById(@Param("idParam") short id);

    @Query("SELECT v FROM Address v WHERE v.name = :nameParam")
    Address findAddressByName(@Param("nameParam") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Address v SET v.name = :nameParam WHERE v.id = :idParam")
    void updateAddress1(@Param("idParam") short id, @Param("nameParam") String name);

}
