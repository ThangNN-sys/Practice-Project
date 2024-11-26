package com.vti.repository;

import com.vti.entity.TypeQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITypeQuestionRepository extends JpaRepository<TypeQuestion, Short> {
    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: TypeQuestion
     */

    @Query("SELECT t FROM TypeQuestion t")
    List<TypeQuestion> findAll();

    @Query("SELECT t FROM TypeQuestion t WHERE t.id = :idParam")
    TypeQuestion findTypeQuestionById(@Param("idParam") short id);

    @Query("SELECT t FROM TypeQuestion t WHERE t.name = :nameParam")
    TypeQuestion findTypeQuestionByName(@Param("nameParam") String name);

    @Modifying
    @Query("UPDATE TypeQuestion t SET t.name = :nameParam WHERE t.id = :idParam")
    void updateTypeQuestion1(@Param("idParam") short id, @Param("nameParam") String name);

}
