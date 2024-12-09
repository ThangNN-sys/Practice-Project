package com.vti.service;

import com.vti.entity.Exam;
import com.vti.entity.ExamQuestion;
import com.vti.entity.Question;
import com.vti.entity.primarykey.ExamQuestionKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IExamQuestionService {

    List<ExamQuestion> getListExamQuestions();

    Page<ExamQuestion> getAllExamQuestions(Pageable pageable);

    ExamQuestion getExamQuestionById(ExamQuestionKey id);

    ExamQuestion getExamQuestionByExam(Exam exam);

    ExamQuestion getExamQuestionByQuestion(Question question);

    void createExamQuestion(ExamQuestion examQuestion);

    void updateExamQuestion1(ExamQuestionKey id, Exam newExam, Question newQuestion);

    void updateExamQuestion2(ExamQuestion examQuestion);

    void deleteExamQuestion(ExamQuestionKey id);

    boolean isExamQuestionExistId(ExamQuestionKey id);

    boolean isExamQuestionExistExam(Exam exam);

    boolean isExamQuestionExistQuestion(Question question);

}
