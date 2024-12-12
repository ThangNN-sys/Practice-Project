package com.vti.repository;

import com.vti.entity.Group;
import jakarta.transaction.Transactional;
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

    @Query("SELECT v FROM Group v")
    List<Group> findAll();

    @Query("SELECT v FROM Group v WHERE v.id = :idParam")
    Group findGroupById(@Param("idParam") short id);

    @Query("SELECT v FROM Group v WHERE v.name = :nameParam")
    Group findGroupByName(@Param("nameParam") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Group v SET v.name = :nameParam WHERE v.id = :idParam")
    void updateGroup1(@Param("idParam") short id, @Param("nameParam") String name);

}
