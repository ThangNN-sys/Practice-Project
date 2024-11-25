package com.vti.repository;

import com.vti.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupRepository extends JpaRepository<Group, Short> {

    Group findById(short id);

    Group findByName(String name);

}
