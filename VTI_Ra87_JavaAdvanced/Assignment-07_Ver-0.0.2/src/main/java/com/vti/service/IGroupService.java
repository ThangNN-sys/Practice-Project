package com.vti.service;

import com.vti.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGroupService {

    List<Group> getListGroups();

    Page<Group> getAllGroups(Pageable pageable);

    Group getGroupById(short id);

    Group getGroupByName(String name);

    void createGroup(Group group);

    void updateGroup1(short id, String newName);

    void updateGroup2(Group group);

    void deleteGroup(short id);

    boolean isGroupExistId(short id);

    boolean isGroupExistName(String name);

}
