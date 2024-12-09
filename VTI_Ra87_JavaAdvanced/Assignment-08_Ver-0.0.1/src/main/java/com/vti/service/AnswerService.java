package com.vti.service;

import com.vti.entity.Answer;
import com.vti.entity.Question;
import com.vti.repository.IAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService implements IAnswerService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: Answer
     */

    @Autowired
    private IAnswerRepository repository;

    // get all
    @Override
    public List<Answer> getListAnswers() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<Answer> getAllAnswers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public Answer getAnswerById(short id) {
        return repository.findAnswerById(id);
    }

    // get by question with @Query
    @Override
    public Answer getAnswerByQuestion(Question question) {
        return repository.findAnswerByQuestion(question);
    }

    // create new
    @Override
    public void createAnswer(Answer answer) {
        repository.save(answer);
    }

    // update find by id
    @Override
    public void updateAnswer1(short id, String content, Question question, boolean isCorrect) {
        repository.updateAnswer1(id, content, question, isCorrect);
    }

    // update by object
    @Override
    public void updateAnswer2(Answer answer) {
        repository.save(answer);
    }

    // delete by id
    @Override
    public void deleteAnswer(short id) {
        repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isAnswerExistId(short id) {
        return repository.existsById(id);
    }

    @Override
    public boolean isAnswerExistQuestion(Question question) {
        Answer answer = repository.findAnswerByQuestion(question);
        return answer != null;
        // return repository.findAnswerByQuestion(question) != null; // cách viết ngắn gọn
    }


    // exists by name


}
