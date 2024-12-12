package com.vti.repository;

import com.vti.entity.DetailDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Data Access Layer - Interface
 * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
 * Đối tượng: DetailDepartment
 */

public interface IDetailDepartmentRepository extends JpaRepository<DetailDepartment, Short> {

    @Query("SELECT v FROM DetailDepartment v WHERE v.id = :departmentId")
    DetailDepartment findByDepartmentId(@Param("departmentId") short departmentId);

}
