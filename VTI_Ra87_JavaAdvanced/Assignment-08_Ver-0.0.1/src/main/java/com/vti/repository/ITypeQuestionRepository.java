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

    @Query("SELECT v FROM TypeQuestion v")
    List<TypeQuestion> findAll();

    @Query("SELECT v FROM TypeQuestion v WHERE v.id = :idParam")
    TypeQuestion findTypeQuestionById(@Param("idParam") short id);

    @Query("SELECT v FROM TypeQuestion v WHERE v.name = :nameParam")
    TypeQuestion findTypeQuestionByName(@Param("nameParam") TypeQuestionName name);

    @Modifying
    @Query("UPDATE TypeQuestion v SET v.name = :nameParam WHERE v.id = :idParam")
    void updateTypeQuestion1(@Param("idParam") short id, @Param("nameParam") TypeQuestionName name);

}
