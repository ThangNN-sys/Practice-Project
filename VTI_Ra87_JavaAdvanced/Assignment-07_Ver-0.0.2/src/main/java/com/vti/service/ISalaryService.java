package com.vti.service;

import com.vti.entity.Salary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISalaryService {

    List<Salary> getAllSalaries();

    Page<Salary> getAllSalaries(Pageable pageable);

    Salary getSalaryById(short id);

    Salary getSalaryByName(String name);

    void createSalary(String name);

    void updateSalary(String name);

    void deleteSalary(String name);

    boolean isSalaryExistId(short id);

    boolean isSalaryExistName(String name);

}
