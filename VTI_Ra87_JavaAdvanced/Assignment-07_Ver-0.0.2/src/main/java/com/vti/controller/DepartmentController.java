package com.vti.controller;

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {

    @Autowired
    private IDepartmentService service;

    // get all departments paging
    @GetMapping()
    public Page<Department> getAllDepartments(Pageable pageable) {
        return service.getAllDepartments(pageable);
    }

    // get department by id
    @GetMapping(value = "/{id}")
    public Department getDepartmentById(@PathVariable(name = "id") short id) {
        return service.getDepartmentById(id);
    }

    // get department by name
    @GetMapping(value = "/name/{name}")
    public Department getDepartmentByName(@PathVariable(name = "name") String name) {
        return service.getDepartmentByName(name);
    }

    // create new department
    @PostMapping()
    public void createDepartment(@RequestBody Department create) {
        service.createDepartment(create.toString());
    }

    // update department name find by id
    @PutMapping(value = "/{id}")
    public void updateDepartment(@RequestBody Department updated) {
        service.updateDepartment(updated.toString());
    }

    // update department by department object
    @PutMapping
    public ResponseEntity<String> updateDepartment1(@RequestBody Department department) {
        try {
            updateDepartment(department);
            return ResponseEntity.ok("Department updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Failed to update department: " + e.getMessage());
        }
    }

    // delete department by id
    @DeleteMapping(value = "/{id}")
    public void deleteDepartment(@PathVariable(name = "id") short id) {
        service.deleteDepartment(String.valueOf(id));
    }

    // is department exists by id
    @GetMapping(value = "/is-exist-id/{id}")
    public boolean isDepartmentExistId(@PathVariable(name = "id") short id) {
        return service.isDepartmentExistId(id);
    }

    // is department exists by name
    @GetMapping(value = "/is-exist-name/{name}")
    public boolean isDepartmentExistName(@PathVariable(name = "name") String name) {
        return service.isDepartmentExistName(name);
    }

}
