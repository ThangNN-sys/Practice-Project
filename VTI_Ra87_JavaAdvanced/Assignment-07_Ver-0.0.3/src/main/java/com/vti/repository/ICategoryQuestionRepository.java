package com.vti.repository;

import com.vti.entity.CategoryQuestion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryQuestionRepository extends JpaRepository<CategoryQuestion, Short> {
    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: CategoryQuestion
     */

    @Query("SELECT c FROM CategoryQuestion c")
    List<CategoryQuestion> findAll();

    @Query("SELECT c FROM CategoryQuestion c WHERE c.id = :idParam")
    CategoryQuestion findCategoryQuestionById(@Param("idParam") short id);

    @Query("SELECT c FROM CategoryQuestion c WHERE c.name = :nameParam")
    CategoryQuestion findCategoryQuestionByName(@Param("nameParam") String name);

    @Modifying
    @Transactional
    @Query("UPDATE CategoryQuestion c SET c.name = :nameParam WHERE c.id = :idParam")
    void updateCategoryQuestion1(@Param("idParam") short id, @Param("nameParam") String name);

}
