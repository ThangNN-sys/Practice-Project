package com.vti.repository;

import com.vti.entity.Position;
import com.vti.entity.enumerate.PositionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPositionRepository extends JpaRepository<Position, Short> {
    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: Position
     */

    @Query("SELECT v FROM Position v")
    List<Position> findAll();

    @Query("SELECT v FROM Position v WHERE v.id = :idParam")
    Position findPositionById(@Param("idParam") short id);

    @Query("SELECT v FROM Position v WHERE v.name = :nameParam")
    Position findPositionByName(@Param("nameParam") PositionName name);

    @Modifying
    @Query("UPDATE Position v SET v.name = :nameParam WHERE v.id = :idParam")
    void updatePosition1(@Param("idParam") short id, @Param("nameParam") PositionName name);

}
