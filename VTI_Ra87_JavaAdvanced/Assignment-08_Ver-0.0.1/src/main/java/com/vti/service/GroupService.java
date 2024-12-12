package com.vti.service;

import com.vti.entity.Group;
import com.vti.repository.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: Group
     */

    @Autowired
    private IGroupRepository repository;

    // get all
    @Override
    public List<Group> getAllGroupsPaging() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<Group> getAllGroupsPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public Group getGroupById(short id) {
        return repository.findGroupById(id);
    }

    // get by name with @Query
    @Override
    public Group getGroupByName(String name) {
        return repository.findGroupByName(name);
    }

    // create new
    @Override
    public void createGroup(Group group) {
        repository.save(group);
    }

    // update name find by id
    @Override
    public void updateGroup1(short id, String newName) {
        repository.updateGroup1(id, newName);
    }

    // update by object
    @Override
    public void updateGroup2(Group group) {
        repository.save(group);
    }

    // delete by id
    @Override
    public void deleteGroup(short id) {
        repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isGroupExistsId(short id) {
        return repository.existsById(id);
    }

    // exists by name
    @Override
    public boolean isGroupExistsName(String name) {
        Group group = repository.findGroupByName(name);
        return group != null;
        // return repository.findGroupByName(name) != null; // cách viết ngắn gọn
    }
}
