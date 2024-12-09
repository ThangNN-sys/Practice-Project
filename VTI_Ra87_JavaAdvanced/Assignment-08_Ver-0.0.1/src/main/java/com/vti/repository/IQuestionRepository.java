package com.vti.repository;

import com.vti.entity.CategoryQuestion;
import com.vti.entity.Question;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IQuestionRepository extends JpaRepository<Question, Short> {
    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: Question
     */

    @Query("SELECT v FROM Question v")
    List<Question> findAll();

    @Query("SELECT v FROM Question v WHERE v.id = :idParam")
    Question findQuestionById(@Param("idParam") short id);

    @Query("SELECT v FROM Question v WHERE v.category = :categoryParam")
    Question findQuestionByCategory(@Param("categoryParam") CategoryQuestion categoryQuestion);

    @Modifying
    @Transactional
    @Query("UPDATE Question v SET v.content = :contentParam WHERE v.id = :idParam")
    void updateQuestion1(@Param("idParam") short id, @Param("contentParam") String content);

}
