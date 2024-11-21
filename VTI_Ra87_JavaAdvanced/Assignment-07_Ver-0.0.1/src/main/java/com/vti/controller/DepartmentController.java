package com.vti.controller;

import com.vti.entity.Department;
import com.vti.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    // get all departments
    @GetMapping()
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
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

    // update department find by department object
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
