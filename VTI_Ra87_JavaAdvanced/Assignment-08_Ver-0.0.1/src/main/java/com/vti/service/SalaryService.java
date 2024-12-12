package com.vti.service;

import com.vti.entity.Salary;
import com.vti.entity.enumerate.SalaryName;
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

    // get all
    @Override
    public List<Salary> getAllSalaries() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<Salary> getAllSalariesPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public Salary getSalaryById(short id) {
        return repository.findSalaryById(id);
    }

    // get by name with @Query
    @Override
    public Salary getSalaryByName(SalaryName name) {
        return repository.findSalaryByName(name);
    }

    // create new
    @Override
    public void createSalary(Salary salary) {
        repository.save(salary);
    }

    // update name find by id
    @Override
    public void updateSalary1(short id, SalaryName newName) {
        updateSalary1(id, newName);
    }

    // update by object
    @Override
    public void updateSalary2(Salary salary) {
        repository.save(salary);
    }

    // delete by id
    @Override
    public void deleteSalary(short id) {
        repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isSalaryExistsId(short id) {

        return repository.existsById(id);
    }

    // exists by name
    @Override
    public boolean isSalaryExistsName(SalaryName name) {
        Salary salary = repository.findSalaryByName(name);
        return salary != null;
        // return repository.findSalaryByName(name) != null; // cách viết ngắn gọn
    }

}
