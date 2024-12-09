package com.vti.repository;

import com.vti.entity.Exam;
import com.vti.entity.ExamQuestion;
import com.vti.entity.Question;
import com.vti.entity.primarykey.ExamQuestionKey;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IExamQuestionRepository extends JpaRepository<ExamQuestion, ExamQuestionKey> {
    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: ExamQuestion
     */

    @Query("SELECT v FROM ExamQuestion v")
    List<ExamQuestion> findAll();

    @Query("SELECT v FROM ExamQuestion v WHERE v.id = :idParam")
    ExamQuestion findExamQuestionById(@Param("idParam") ExamQuestionKey id);

    @Query("SELECT v FROM ExamQuestion v WHERE v.exam = :examParam")
    ExamQuestion findExamQuestionByExam(@Param("examParam") Exam exam);

    @Query("SELECT v FROM ExamQuestion v WHERE v.question = :questionParam")
    ExamQuestion findExamQuestionByQuestion(@Param("questionParam") Question question);

    @Modifying
    @Transactional
    @Query("UPDATE ExamQuestion v SET v.exam = :examParam, v.question = :questionParam WHERE v.id = :idParam")
    void updateExamQuestion1(@Param("idParam") ExamQuestionKey id, @Param("examParam") Exam exam, @Param("questionParam") Question question);

}
