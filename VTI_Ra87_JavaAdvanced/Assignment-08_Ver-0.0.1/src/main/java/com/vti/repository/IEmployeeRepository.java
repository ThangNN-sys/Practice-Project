package com.vti.repository;

import com.vti.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Short> {
    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: Employee
     */

    @Query("SELECT v FROM Employee v")
    List<Employee> findAll();

    @Query("SELECT v FROM Employee v WHERE v.accountId = :idParam")
    Employee findEmployeeByAccId(@Param("idParam") short id);

    @Query("SELECT v FROM Employee v WHERE v.workingNumberOfYear = :yearParam")
    Employee findEmployeeByYear(@Param("yearParam") short year);

    @Modifying
    @Transactional
    @Query("UPDATE Employee v SET v.workingNumberOfYear = :yearParam WHERE v.accountId = :idParam")
    void updateEmployee1(@Param("idParam") short id, @Param("yearParam") short year);

}
