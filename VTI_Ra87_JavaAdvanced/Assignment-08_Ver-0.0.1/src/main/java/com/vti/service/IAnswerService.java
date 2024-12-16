package com.vti.service;

import com.vti.entity.Answer;
import com.vti.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAnswerService {

    List<Answer> getAllAnswers();

    Page<Answer> getAllAnswersPaging(Pageable pageable);

    Answer getAnswerById(short id);

    Answer getAnswerByQuestion(Question question);

    void createAnswer(Answer answer);

    void updateAnswer1(short id, String content, Question question, boolean isCorrect);

    void updateAnswer2(Answer answer);

    void deleteAnswer(short id);

    boolean isAnswerExistsId(short id);

    boolean isAnswerExistsQuestion(Question question);

}
