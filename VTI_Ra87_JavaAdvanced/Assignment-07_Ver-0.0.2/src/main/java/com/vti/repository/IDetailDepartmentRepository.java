package com.vti.repository;

import com.vti.entity.DetailDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailDepartmentRepository extends JpaRepository<DetailDepartment, Short> {
    DetailDepartment findDetailDepartmentById(short id);
    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: DetailDepartment
     */

}
