package com.vti.service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: Department
     */

    @Autowired
    private IDepartmentRepository repository;

    // get all
    @Override
    public List<Department> getListDepartments() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<Department> getPageDepartments(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public Department getDepartmentById(short id) {
        return repository.findDepartmentById(id);
    }

    // get by name with @Query
    @Override
    public Department getDepartmentByName(String name) {
        return repository.findDepartmentByName(name);
    }

    // create new
    @Override
    public void createDepartment(Department department) {
        repository.save(department);
    }

    // update name find by id
    @Override
    public void updateDepartment1(short id, String newName) {
        repository.updateDepartment1(id, newName);
    }

    // update by object
    @Override
    public void updateDepartment2(Department department) {
        repository.save(department);
    }

    // delete by id
    @Override
    public void deleteDepartment(short id) {
        repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isDepartmentExistId(short id) {
        return repository.existsById(id);
    }

    // exists by name
    @Override
    public boolean isDepartmentExistName(String name) {
        Department department = repository.findDepartmentByName(name);
        return department != null;
        // return repository.findDepartmentByName(name) != null; // cách viết ngắn gọn
    }
}
