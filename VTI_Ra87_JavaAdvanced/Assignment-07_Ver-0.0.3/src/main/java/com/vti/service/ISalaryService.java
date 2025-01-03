package com.vti.service;

import com.vti.entity.Salary;
import com.vti.entity.enumerate.SalaryName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISalaryService {

    List<Salary> getListSalaries();

    Page<Salary> getAllSalaries(Pageable pageable);

    Salary getSalaryById(short id);

    Salary getSalaryByName(SalaryName name);

    void createSalary(Salary salary);

    void updateSalary1(short id, SalaryName newName);

    void updateSalary2(Salary salary);

    void deleteSalary(short id);

    boolean isSalaryExistId(short id);

    boolean isSalaryExistName(SalaryName name);

}
