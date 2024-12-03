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

    @Query("SELECT e FROM Employee e")
    List<Employee> findAll();

    @Query("SELECT e FROM Employee e WHERE e.accountId = :idParam")
    Employee findEmployeeByAccId(@Param("idParam") short id);

    @Query("SELECT e FROM Employee e WHERE e.workingNumberOfYear = :yearParam")
    Employee findEmployeeByYear(@Param("yearParam") short year);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.workingNumberOfYear = :yearParam WHERE e.accountId = :idParam")
    void updateEmployee1(@Param("idParam") short id, @Param("yearParam") short year);

}
