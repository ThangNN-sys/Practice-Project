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

    @Query("SELECT v FROM Salary v")
    List<Salary> findAll();

    @Query("SELECT v FROM Salary v WHERE v.id = :idParam")
    Salary findSalaryById(@Param("idParam") short id);

    @Query("SELECT v FROM Salary v WHERE v.name = :nameParam")
    Salary findSalaryByName(@Param("nameParam") SalaryName name);

    @Modifying
    @Query("UPDATE Salary v SET v.name = :nameParam WHERE v.id = :idParam")
    void updateSalary1(@Param("idParam") short id, @Param("nameParam") SalaryName name);

}
