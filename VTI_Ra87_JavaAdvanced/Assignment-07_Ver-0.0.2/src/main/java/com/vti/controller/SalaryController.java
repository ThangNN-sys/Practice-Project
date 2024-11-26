package com.vti.controller;

import com.vti.entity.Salary;
import com.vti.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/salaries")
public class SalaryController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: Salary
     */

    @Autowired
    private ISalaryService service;

    // get all paging
    @GetMapping()
    public Page<Salary> getAllSalaries(Pageable pageable) {
        return service.getAllSalaries(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public Salary getSalaryById(@PathVariable(name = "id") short id) {
        return service.getSalaryById(id);
    }

    // get by name
    @GetMapping(value = "/name/{name}")
    public Salary getSalaryByName(@PathVariable(name = "name") String name) {
        return service.getSalaryByName(name);
    }

    // create new
    @PostMapping()
    public void createSalary(@RequestBody Salary create) {
        service.createSalary(create);
    }

    // update name find by id
    @PutMapping(value = "/u1/{id}")
    public void updateSalary1(@RequestBody Salary updated) {
        service.updateSalary1();
    }

    // update by object


    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteSalary(@PathVariable(name = "id") short id) {
        service.deleteSalary(String.valueOf(id));
    }

    // exists by id
    @GetMapping(value = "/is-exist-id/{id}")
    public boolean isSalaryExistId(@PathVariable(name = "id") short id) {
        return service.isSalaryExistId(id);
    }

    // exists by name
    @GetMapping(value = "/is-exist-name/{name}")
    public boolean isSalaryExistName(@PathVariable(name = "name") String name) {
        return service.isSalaryExistName(name);
    }

}
