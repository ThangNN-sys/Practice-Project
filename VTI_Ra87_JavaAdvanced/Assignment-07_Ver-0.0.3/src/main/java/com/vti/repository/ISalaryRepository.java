package com.vti.repository;

import com.vti.entity.Salary;
import com.vti.entity.enumerate.SalaryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISalaryRepository extends JpaRepository<Salary, Short> {
    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: Salary
     */

    @Query("SELECT s FROM Salary s")
    List<Salary> findAll();

    @Query("SELECT s FROM Salary s WHERE s.id = :idParam")
    Salary findSalaryById(@Param("idParam") short id);

    @Query("SELECT s FROM Salary s WHERE s.name = :nameParam")
    Salary findSalaryByName(@Param("nameParam") SalaryName name);

    @Modifying
    @Query("UPDATE Salary s SET s.name = :nameParam WHERE s.id = :idParam")
    void updateSalary1(@Param("idParam") short id, @Param("nameParam") SalaryName name);

}
