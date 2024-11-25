package com.vti.controller;

import com.vti.entity.Salary;
import com.vti.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/salarys")
public class SalaryController {
    @Autowired
    private ISalaryService salaryService;

    @GetMapping()
    public Page<Salary> getAllSalarys(Pageable pageable) {
        return salaryService.getAllSalarys(pageable);
    }

    @GetMapping(value = "/{id}")
    public Salary getSalaryById(@PathVariable(name = "id") short id) {
        return salaryService.getSalaryByID(id);
    }

    @GetMapping(value = "/name")
    public Salary getSalaryByName(@RequestParam(name = "name") String name) {
        return salaryService.getSalaryByName(name);
    }

    @PostMapping()
    public void createSalary(@RequestBody Salary salary) {
        salaryService.createSalary(salary);
    }

    @PutMapping(value = "/{id}")
    public void updateSalary(@PathVariable(name = "id") short id, @RequestBody Salary salary) {
        salary.setSalaryId(id);
        salaryService.updateSalary(salary);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSalary(@PathVariable(name = "id") short id) {
        salaryService.deleteSalary(id);
    }
}
