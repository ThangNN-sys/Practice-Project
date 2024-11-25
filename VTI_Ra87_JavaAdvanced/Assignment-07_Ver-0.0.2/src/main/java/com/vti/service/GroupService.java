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

    @Override
    public List<Group> getAllGroups() {
        return List.of();
    }

    @Override
    public Page<Group> getAllGroups(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Group getGroupById(short id) {
        return repository.findById(id);
    }

    @Override
    public Group getGroupByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void createGroup(String name) {

    }

    @Override
    public void updateGroup(String name) {

    }

    @Override
    public void deleteGroup(String name) {

    }

    @Override
    public boolean isGroupExistId(short id) {
        return false;
    }

    @Override
    public boolean isGroupExistName(String name) {
        return false;
    }
}
