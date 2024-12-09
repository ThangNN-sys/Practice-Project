package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.Manager;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IManagerRepository extends JpaRepository<Manager, Short> {
    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: Manager
     */

    @Query("SELECT v FROM Manager v")
    List<Manager> findAll();

    @Query("SELECT v FROM Manager v WHERE v.id = :idParam")
    Manager findManagerById(@Param("idParam") short id);

    @Query("SELECT v FROM Manager v WHERE v.managementNumberOfYear = :yearParam")
    Manager findManagerByYear(@Param("yearParam") short year);

    @Modifying
    @Transactional
    @Query("UPDATE Manager v SET v.managementNumberOfYear = :yearParam WHERE v.id = :idParam")
    void updateManager1(@Param("idParam") short id, @Param("nameParam") short year);

}
