package com.vti.repository;

import com.vti.entity.Position;
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

    Position findById(short id);

    Position findByName(String name);

    @Query("SELECT p FROM Position p")
    List<Position> findAll();

    @Query("SELECT p FROM Position p WHERE p.id = :idParam")
    Position findPositionById(@Param("idParam") short id);

    @Query("SELECT p FROM Position p WHERE p.name = :nameParam")
    Position findPositionByName(@Param("nameParam") String name);

    @Modifying
    @Query("UPDATE Position p SET p.name = :nameParam WHERE p.id = :idParam")
    void updatePosition(@Param("idParam") short id, @Param("nameParam") String name);

    @Modifying
    @Query("DELETE FROM Position p WHERE p.id = :idParam")
    void deletePosition(@Param("idParam") short id);

}
