package com.vti.service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository repository;

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Department getDepartmentById(short id) {
        return repository.findById(id);
    }

    public Department getDepartmentByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void createDepartment(String name) {

    }

    @Override
    public void updateDepartment(String name) {

    }

    @Override
    public void deleteDepartment(String name) {

    }

    public boolean isDepartmentExistId(short id) {
        return false;
    }

    public boolean isDepartmentExistName(String name) {

        return false;
    }

}
