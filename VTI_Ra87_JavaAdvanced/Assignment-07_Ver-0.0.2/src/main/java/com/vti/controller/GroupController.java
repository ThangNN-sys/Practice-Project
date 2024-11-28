package com.vti.controller;

import com.vti.entity.Group;
import com.vti.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/groups")
public class GroupController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: Group
     */

    @Autowired
    private IGroupService service;

    // get all list
//    @GetMapping()
//    public List<Group> getListGroups() {
//        return service.getListGroups();
//    }

    // get all paging
    @GetMapping()
    public Page<Group> getAllGroups(Pageable pageable) {
        return service.getAllGroups(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public Group getGroupById(@PathVariable(name = "id") short id) {
        return service.getGroupById(id);
    }

    // get by name
    @GetMapping(value = "/name/{name}")
    public Group getGroupByName(@PathVariable(name = "name") String name) {
        return service.getGroupByName(name);
    }

    // create new
    @PostMapping()
    public void createGroup(@RequestBody Group create) {
        service.createGroup(create);
    }

    // update name find by id
    @PutMapping(value = "/u1/{id}")
    public void updateGroup1(@PathVariable(name = "id") short id, @RequestBody Group update1) {
        update1.setGroupId(id);
        service.updateGroup1(id, update1.getGroupName());
    }

    // update by object
    @PutMapping(value = "/u2/{id}")
    public void updateGroup2(@PathVariable(name = "id") short id, @RequestBody Group update2) {
        service.updateGroup2(update2);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteGroup(@PathVariable(name = "id") short id) {
        service.deleteGroup(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isGroupExistId(@PathVariable(name = "id") short id) {
        return service.isGroupExistId(id);
    }

    // exists by name
    @GetMapping(value = "/exists-name/{name}")
    public boolean isGroupExistName(@PathVariable(name = "name") String name) {
        return service.isGroupExistName(name);
    }

}
