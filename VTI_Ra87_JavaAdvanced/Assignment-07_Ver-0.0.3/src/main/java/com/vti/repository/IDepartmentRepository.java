package com.vti.repository;

import com.vti.entity.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Short> {
    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: Department
     */

    @Query("SELECT d FROM Department d")
    List<Department> findAll();

    @Query("SELECT d FROM Department d WHERE d.id = :idParam")
    Department findDepartmentById(@Param("idParam") short id);

    @Query("SELECT d FROM Department d WHERE d.name = :nameParam")
    Department findDepartmentByName(@Param("nameParam") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Department d SET d.name = :nameParam WHERE d.id = :idParam")
    void updateDepartment1(@Param("idParam") short id, @Param("nameParam") String name);

}
