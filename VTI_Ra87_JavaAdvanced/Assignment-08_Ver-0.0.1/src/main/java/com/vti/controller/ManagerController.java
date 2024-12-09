package com.vti.controller;

import com.vti.entity.Manager;
import com.vti.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/managers")
public class ManagerController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: Manager
     */

    @Autowired
    private IManagerService service;

    // get all list
//    @GetMapping()
//    public List<Manager> getListManagers() {
//        return service.getListManageres();
//    }

    // get all paging
    @GetMapping()
    public Page<Manager> getAllManagers(Pageable pageable) {
        return service.getAllManagers(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public Manager getManagerById(@PathVariable(name = "id") short id) {
        return service.getManagerById(id);
    }

    // get by year
    @GetMapping(value = "/year/{year}")
    public Manager getManagerByYear(@PathVariable(name = "year") short year) {
        return service.getManagerByYear(year);
    }

    // create new
    @PostMapping()
    public void createManager(@RequestBody Manager create) {
        service.createManager(create);
    }

    // update find by id
    @PutMapping(value = "/u1/{id}")
    public void updateManager1(@PathVariable(name = "id") short id, @RequestBody Manager update1) {
        update1.setId(id);
        service.updateManager1(id, update1.getManagementNumberOfYear());
    }

    // update by object
    @PutMapping(value = "/u2")
    public void updateManager2(@RequestBody Manager update2) {
        service.updateManager2(update2);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteManager(@PathVariable(name = "id") short id) {
        service.deleteManager(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isManagerExistId(@PathVariable(name = "id") short id) {
        return service.isManagerExistId(id);
    }

    // exists by year
    @GetMapping(value = "/exists-year/{year}")
    public boolean isManagerExistYear(@PathVariable(name = "year") short year) {
        return service.isManagerExistYear(year);
    }

}
