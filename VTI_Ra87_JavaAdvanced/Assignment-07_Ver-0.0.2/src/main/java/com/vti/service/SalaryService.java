package com.vti.service;

import com.vti.entity.Salary;
import com.vti.repository.ISalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService implements ISalaryService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: Salary
     */

    @Autowired
    private ISalaryRepository repository;


    @Override
    public List<Salary> getAllSalaries() {
        return List.of();
    }

    @Override
    public Page<Salary> getAllSalaries(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Salary getSalaryById(short id) {
        return repository.findById(id);
    }

    @Override
    public Salary getSalaryByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void createSalary(String name) {

    }

    @Override
    public void updateSalary(String name) {

    }

    @Override
    public void deleteSalary(String name) {

    }

    @Override
    public boolean isSalaryExistId(short id) {
        return false;
    }

    @Override
    public boolean isSalaryExistName(String name) {
        return false;
    }
}
