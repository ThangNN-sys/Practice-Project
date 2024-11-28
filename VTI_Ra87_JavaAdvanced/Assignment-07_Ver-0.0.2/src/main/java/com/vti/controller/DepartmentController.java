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
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: Department
     */

    @Autowired
    private IDepartmentService service;

    // get all list - can't run same time with get all paging
//    @GetMapping()
//    public List<Department> getListDepartments() {
//        return service.getListDepartments();
//    }

    // get all paging
    @GetMapping()
    public Page<Department> getAllDepartments(Pageable pageable) {
        return service.getPageDepartments(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public Department getDepartmentById(@PathVariable(name = "id") short id) {
        return service.getDepartmentById(id);
    }

    // get by name
    @GetMapping(value = "/name/{name}")
    public Department getDepartmentByName(@PathVariable(name = "name") String name) {
        return service.getDepartmentByName(name);
    }

    // create new
    @PostMapping()
    public void createDepartment(@RequestBody Department create) {
        service.createDepartment(create);
    }

    // update name find by id
    @PutMapping(value = "/u1/{id}")
    public void updateDepartment1(@PathVariable(name = "id") short id, @RequestBody Department update1) {
        update1.setDepartmentId(id);
        service.updateDepartment1(id, update1.getDepartmentName());
    }

    // update by object
    @PutMapping(value = "/u2")
    public void updateDepartment2(@RequestBody Department update2) {
        service.updateDepartment2(update2);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteDepartment(@PathVariable(name = "id") short id) {
        service.deleteDepartment(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isDepartmentExistId(@PathVariable(name = "id") short id) {
        return service.isDepartmentExistId(id);
    }

    // exists by name
    @GetMapping(value = "/exists-name/{name}")
    public boolean isDepartmentExistName(@PathVariable(name = "name") String name) {
        return service.isDepartmentExistName(name);
    }

}
