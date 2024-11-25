package com.vti.repository;

import com.vti.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupRepository extends JpaRepository<Group, Short> {

    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: Group
     */

    Group findById(short id);

    Group findByName(String name);

}
