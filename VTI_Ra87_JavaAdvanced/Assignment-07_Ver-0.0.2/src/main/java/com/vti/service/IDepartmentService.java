package com.vti.service;

import com.vti.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {

    List<Department> getAllDepartments();

    Page<Department> getAllDepartments(Pageable pageable);

    Department getDepartmentById(short id);

    Department getDepartmentByName(String name);

    void createDepartment(Department department);

    void updateDepartment1(short id, String newName);

    void updateDepartment2(Department department);

    void deleteDepartment(short id);

    boolean isDepartmentExistId(short id);

    boolean isDepartmentExistName(String name);

}
