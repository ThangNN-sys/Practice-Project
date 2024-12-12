package com.vti.controller;

import com.vti.entity.DetailDepartment;
import com.vti.service.IDetailDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/detaildepartments")
public class DetailDepartmentController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: DetailDepartment
     */

    @Autowired
    private IDetailDepartmentService service;

    // get all list
//    @GetMapping()
//    public List<DetailDepartment> getListDetailDepartments() {
//        return service.getListDetailDepartments();
//    }

    // get all paging
    @GetMapping()
    public Page<DetailDepartment> getAllDetailDepartments(Pageable pageable) {
        return service.getAllDetailDepartmentsPaging(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public DetailDepartment getDetailDepartmentById(@PathVariable(name = "id") short id) {
        return service.getDetailDepartmentById(id);
    }

    // create new
    @PostMapping()
    public void createDetailDepartment(@RequestBody DetailDepartment create) {
        service.createDetailDepartment(create);
    }

    // update by object
    @PutMapping(value = "/u2")
    public void updateDetailDepartment2(@RequestBody DetailDepartment update) {
        service.updateDetailDepartment2(update);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteDetailDepartment(@PathVariable(name = "id") short id) {
        service.deleteDetailDepartment(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isDetailDepartmentExistId(@PathVariable(name = "id") short id) {
        return service.isDetailDepartmentExistsId(id);
    }


}
