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

    @Query("SELECT v FROM Department v")
    List<Department> findAll();

    @Query("SELECT v FROM Department v WHERE v.id = :idParam")
    Department findDepartmentById(@Param("idParam") short id);

    @Query("SELECT v FROM Department v WHERE v.name = :nameParam")
    Department findDepartmentByName(@Param("nameParam") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Department v SET v.name = :nameParam WHERE v.id = :idParam")
    void updateDepartment1(@Param("idParam") short id, @Param("nameParam") String name);

}
