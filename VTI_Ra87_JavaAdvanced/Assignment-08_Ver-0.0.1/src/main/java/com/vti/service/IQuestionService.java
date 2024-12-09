package com.vti.service;

import com.vti.entity.CategoryQuestion;
import com.vti.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestionService {

    List<Question> getListQuestions();

    Page<Question> getAllQuestions(Pageable pageable);

    Question getQuestionById(short id);

    Question getQuestionByCategory(CategoryQuestion category);

    void createQuestion(Question question);

    void updateQuestion1(short id, String newContent);

    void updateQuestion2(Question question);

    void deleteQuestion(short id);

    boolean isQuestionExistId(short id);

    boolean isQuestionExistCategory(CategoryQuestion category);

}
