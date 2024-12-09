package com.vti.service;

import com.vti.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getListEmployees();

    Page<Employee> getAllEmployees(Pageable pageable);

    Employee getEmployeeByAccId(short id);

    Employee getEmployeeByYear(short year);

    void createEmployee(Employee employee);

    void updateEmployee1(short id, short newYear);

    void updateEmployee2(Employee employee);

    void deleteEmployee(short id);

    boolean isEmployeeExistId(short id);

    boolean isEmployeeExistYear(short year);

}
