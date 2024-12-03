package com.vti.service;

import com.vti.entity.Employee;
import com.vti.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: Employee
     */

    @Autowired
    private IEmployeeRepository repository;

    // get all
    @Override
    public List<Employee> getListEmployees() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<Employee> getAllEmployees(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public Employee getEmployeeByAccId(short id) {
        return repository.findEmployeeByAccId(id);
    }

    // get by year with @Query
    @Override
    public Employee getEmployeeByYear(short year) {
        return repository.findEmployeeByYear(year);
    }

    // create new
    @Override
    public void createEmployee(Employee employee) {
        repository.save(employee);
    }

    // update name find by id
    @Override
    public void updateEmployee1(short id, short newYear) {
        repository.updateEmployee1(id,newYear);
    }

    // update by object
    @Override
    public void updateEmployee2(Employee employee) {
        repository.save(employee);
    }

    // delete by id
    @Override
    public void deleteEmployee(short id) {
       repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isEmployeeExistId(short id) {
        return repository.existsById(id);
    }

    // exists by name
    @Override
    public boolean isEmployeeExistYear(short year) {
        Employee employee = repository.findEmployeeByYear(year);
        return employee != null;
        // return repository.isEmployeeExistYear(year) != null; // cách viết ngắn gọn
    }

}
