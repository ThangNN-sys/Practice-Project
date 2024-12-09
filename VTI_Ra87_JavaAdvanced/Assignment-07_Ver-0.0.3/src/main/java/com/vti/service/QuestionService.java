package com.vti.service;

import com.vti.entity.Address;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.Question;
import com.vti.repository.IAddressRepository;
import com.vti.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: Question
     */

    @Autowired
    private IQuestionRepository repository;

    // get all
    @Override
    public List<Question> getListQuestions() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<Question> getAllQuestions(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public Question getQuestionById(short id) {
        return repository.findQuestionById(id);
    }

    // get by category with @Query
    @Override
    public Question getQuestionByCategory(CategoryQuestion category) {
        return repository.findQuestionByCategory(category);
    }

    // create new
    @Override
    public void createQuestion(Question question) {
        repository.save(question);
    }

    // update name find by id
    @Override
    public void updateQuestion1(short id, String newContent) {
        Question question = repository.findQuestionById(id);
        question.setContent(newContent);
    }

    // update by object
    @Override
    public void updateQuestion2(Question question) {
        repository.save(question);
    }

    // delete by id
    @Override
    public void deleteQuestion(short id) {
        repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isQuestionExistId(short id) {
        return repository.existsById(id);
    }

    // exists by category
    @Override
    public boolean isQuestionExistCategory(CategoryQuestion category) {
        Question question = repository.findQuestionByCategory(category);
        return question != null;
        // return repository.findQuestionByCategory(categoryQuestion) != null; // cách viết ngắn gọn
    }
























}
