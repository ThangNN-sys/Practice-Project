package com.vti.service;

import com.vti.entity.Answer;
import com.vti.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAnswerService {

    List<Answer> getListAnswers();

    Page<Answer> getAllAnswers(Pageable pageable);

    Answer getAnswerById(short id);

    Answer getAnswerByQuestion(Question question);

    void createAnswer(Answer answer);

    void updateAnswer1(short id, String content, Question question, boolean isCorrect);

    void updateAnswer2(Answer answer);

    void deleteAnswer(short id);

    boolean isAnswerExistId(short id);

    boolean isAnswerExistQuestion(Question question);

}
