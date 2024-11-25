package com.vti.controller;

import com.vti.entity.DetailDepartment;
import com.vti.service.IDetailDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/detailDepartments")
public class DetailDepartmentController {
    @Autowired
    private IDetailDepartmentService detailDepartmentService;

    @GetMapping()
    public Page<DetailDepartment> getAllDetailDepartments(Pageable pageable) {
        return detailDepartmentService.getAllDetailDepartments(pageable);
    }

    @GetMapping(value = "/{id}")
    public DetailDepartment getDetailDepartmentById(@PathVariable(name = "id") short id) {
        return detailDepartmentService.getDetailDepartmentByID(id);
    }

    @PostMapping()
    public void createDetailDepartment(@RequestBody DetailDepartment detailDepartment) {
        detailDepartmentService.createDetailDepartment(detailDepartment);
    }

    @PutMapping(value = "/{id}")
    public void updateDetailDepartment(@PathVariable(name = "id") short id, @RequestBody DetailDepartment detailDepartment) {
        detailDepartment.setId(id);
        detailDepartmentService.updateDetailDepartment(detailDepartment);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDetailDepartment(@PathVariable(name = "id") short id) {
        detailDepartmentService.deleteDetailDepartment(id);
    }
}
