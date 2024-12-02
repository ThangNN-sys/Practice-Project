package com.vti.repository;

import com.vti.entity.Answer;
import com.vti.entity.Question;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Data Access Layer - Interface
 * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
 * Đối tượng: Answer
 */

public interface IAnswerRepository extends JpaRepository<Answer, Short> {

    @Query("SELECT a FROM Answer a")
    List<Answer> findAll();

    @Query("SELECT a FROM Answer a WHERE a.id = :idParam")
    Answer findAnswerById(@Param("idParam") short id);

    @Query("SELECT a FROM Answer a WHERE a.question = :questionParam")
    Answer findAnswerByQuestion(@Param("questionParam") Question question);

    @Modifying
    @Transactional
    @Query("UPDATE Answer a SET a.content = :contentParam, a.question = :questionParam, a.isCorrect = :isCorrectParam WHERE a.id = :idParam")
    void updateAnswer1(@Param("idParam") short id, @Param("contentParam") String content, @Param("questionParam") Question question, @Param("isCorrectParam") boolean isCorrect);
}
