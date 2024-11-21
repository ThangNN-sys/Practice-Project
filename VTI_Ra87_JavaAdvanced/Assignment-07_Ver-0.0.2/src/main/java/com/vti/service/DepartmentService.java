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

    @Autowired
    private IDepartmentRepository repository;

    @Override
    public List<Department> getAllDepartments() {
        return List.of();
    }

    @Override
    public Page<Department> getAllDepartments(Pageable pageable) {
        return repository.findAll(pageable);
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
