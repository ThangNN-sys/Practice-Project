package com.vti.service;

import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentService {

    public List<Department> getAllDepartments();

    public Department getDepartmentById(short id);

    public Department getDepartmentByName(String name);

    public void createDepartment(String name);

    public void updateDepartment(String name);

    public void deleteDepartment(String name);

    public boolean isDepartmentExistId(short id);

    public boolean isDepartmentExistName(String name);

}
