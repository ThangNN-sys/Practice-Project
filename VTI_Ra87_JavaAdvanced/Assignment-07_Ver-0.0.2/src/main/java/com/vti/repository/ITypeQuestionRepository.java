package com.vti.repository;

import com.vti.entity.TypeQuestion;
import com.vti.entity.enumerate.TypeQuestionName;
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

    @Query("SELECT t FROM TypeQuestion t WHERE t.typeId = :idParam")
    TypeQuestion findTypeQuestionById(@Param("idParam") short id);

    @Query("SELECT t FROM TypeQuestion t WHERE t.typeName = :nameParam")
    TypeQuestion findTypeQuestionByName(@Param("nameParam") TypeQuestionName name);

    @Modifying
    @Query("UPDATE TypeQuestion t SET t.typeName = :nameParam WHERE t.typeId = :idParam")
    void updateTypeQuestion1(@Param("idParam") short id, @Param("nameParam") TypeQuestionName name);

}
