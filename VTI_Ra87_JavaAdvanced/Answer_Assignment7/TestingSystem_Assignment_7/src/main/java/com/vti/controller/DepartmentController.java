package com.vti.controller;

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping()
    public Page<Department> getAllDepartments(Pageable pageable) {
        return departmentService.getAllDepartments(pageable);
    }

    @GetMapping(value = "/{id}")
    public Department getDepartmentById(@PathVariable(name = "id") short id) {
        return departmentService.getDepartmentByID(id);
    }

    @GetMapping(value = "/name")
    public Department getDepartmentByName(@RequestParam(name = "name") String name) {
        return departmentService.getDepartmentByName(name);
    }

    @PostMapping()
    public void createDepartment(@RequestBody Department department) {
        departmentService.createDepartment(department);
    }

    @PutMapping(value = "/u1/{id}")
    public void updateDepartment1(@PathVariable(name = "id") short id, @RequestBody Department department) {
        department.setId(id);
        departmentService.updateDepartment1(id, department.getName());
    }

    @PutMapping(value = "/u2/{id}")
    public void updateDepartment2(@PathVariable(name = "id") short id, @RequestBody Department department) {
        departmentService.updateDepartment2(department);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDepartment(@PathVariable(name = "id") short id) {
        departmentService.deleteDepartment(id);
    }
}
