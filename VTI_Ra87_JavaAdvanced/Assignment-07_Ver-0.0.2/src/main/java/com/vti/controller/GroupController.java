package com.vti.controller;

import com.vti.entity.Group;
import com.vti.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
        service.createGroup(create.toString());
    }

    // update name find by id
    @PutMapping(value = "/{id}")
    public void updateGroup(@RequestBody Group updated) {
        service.updateGroup(updated.toString());
    }

    // update by object
    @PutMapping
    public ResponseEntity<String> updateGroup1(@RequestBody Group group) {
        try {
            updateGroup1(group);
            return ResponseEntity.ok("Group updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Failed to update group: " + e.getMessage());
        }
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteGroup(@PathVariable(name = "id") short id) {
        service.deleteGroup(String.valueOf(id));
    }

    // exists by id
    @GetMapping(value = "/is-exist-id/{id}")
    public boolean isGroupExistId(@PathVariable(name = "id") short id) {
        return service.isGroupExistId(id);
    }

    // exists by name
    @GetMapping(value = "/is-exist-name/{name}")
    public boolean isGroupExistName(@PathVariable(name = "name") String name) {
        return service.isGroupExistName(name);
    }

}
