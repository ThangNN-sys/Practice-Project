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

    void createDepartment(String name);

    void updateDepartment(String name);

    void deleteDepartment(String name);

    boolean isDepartmentExistId(short id);

    boolean isDepartmentExistName(String name);

}
