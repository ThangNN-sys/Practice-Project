package com.vti.repository;

import com.vti.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalaryRepository extends JpaRepository<Salary, Short> {

    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: Salary
     */

    Salary findById(short id);

    Salary findByName(String name);

}
