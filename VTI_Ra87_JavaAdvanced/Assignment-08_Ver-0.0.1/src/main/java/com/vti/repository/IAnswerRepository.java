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

    @Query("SELECT v FROM Answer v")
    List<Answer> findAll();

    @Query("SELECT v FROM Answer v WHERE v.id = :idParam")
    Answer findAnswerById(@Param("idParam") short id);

    @Query("SELECT v FROM Answer v WHERE v.question = :questionParam")
    Answer findAnswerByQuestion(@Param("questionParam") Question question);

    @Modifying
    @Transactional
    @Query("UPDATE Answer v SET v.content = :contentParam, v.question = :questionParam, v.isCorrect = :isCorrectParam WHERE a.id = :idParam")
    void updateAnswer1(@Param("idParam") short id, @Param("contentParam") String content, @Param("questionParam") Question question, @Param("isCorrectParam") boolean isCorrect);
}
