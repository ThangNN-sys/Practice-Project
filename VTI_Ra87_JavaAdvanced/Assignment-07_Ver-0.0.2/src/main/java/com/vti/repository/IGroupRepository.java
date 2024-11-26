package com.vti.repository;

import com.vti.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGroupRepository extends JpaRepository<Group, Short> {
    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: Group
     */

    @Query("SELECT g FROM Group g")
    List<Group> findAll();

    @Query("SELECT g FROM Group g WHERE g.id = :idParam")
    Group findGroupById(@Param("idParam") short id);

    @Query("SELECT g FROM Group g WHERE g.name = :nameParam")
    Group findGroupByName(@Param("nameParam") String name);

    @Modifying
    @Query("UPDATE Group g SET g.name = :nameParam WHERE g.id = :idParam")
    void updateGroup1(@Param("idParam") short id, @Param("nameParam") String name);

}
