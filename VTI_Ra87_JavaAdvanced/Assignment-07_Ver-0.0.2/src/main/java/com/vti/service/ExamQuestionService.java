package com.vti.service;

import com.vti.entity.Exam;
import com.vti.entity.ExamQuestion;
import com.vti.entity.Question;
import com.vti.entity.primarykey.ExamQuestionKey;
import com.vti.repository.IExamQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamQuestionService implements IExamQuestionService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: ExamQuestion
     */

    @Autowired
    private IExamQuestionRepository repository;

    // get all
    @Override
    public List<ExamQuestion> getListExamQuestions() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<ExamQuestion> getAllExamQuestions(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public ExamQuestion getExamQuestionById(ExamQuestionKey id) {
        return repository.findExamQuestionById(id);
    }

    // get by exam with @Query
    @Override
    public ExamQuestion getExamQuestionByExam(Exam exam) {
        return repository.findExamQuestionByExam(exam);
    }

    // get by question with @Query
    @Override
    public ExamQuestion getExamQuestionByQuestion(Question question) {
        return repository.findExamQuestionByQuestion(question);
    }

    // create new
    @Override
    public void createExamQuestion(ExamQuestion examQuestion) {
        repository.save(examQuestion);
    }

    // update name find by id
    @Override
    public void updateExamQuestion1(ExamQuestionKey id, Exam newExam, Question newQuestion) {
        ExamQuestion examQuestion = repository.findExamQuestionById(id);
        repository.save(examQuestion);
    }

    // update by object
    @Override
    public void updateExamQuestion2(ExamQuestion examQuestion) {
        repository.save(examQuestion);
    }

    // delete by id
    @Override
    public void deleteExamQuestion(ExamQuestionKey id) {
        repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isExamQuestionExistId(ExamQuestionKey id) {
        return repository.existsById(id);
    }

    // exists by exam
    @Override
    public boolean isExamQuestionExistExam(Exam exam) {
        ExamQuestion examQuestion = repository.findExamQuestionByExam(exam);
        return examQuestion != null;
        // return repository.findExamQuestionByExam(exam) != null; // cách viết ngắn gọn
    }

    // exists by question
    @Override
    public boolean isExamQuestionExistQuestion(Question question) {
        ExamQuestion examQuestion = repository.findExamQuestionByQuestion(
                question);
        return examQuestion != null;
        // return repository.findExamQuestionByQuestion(question) != null; // cách viết ngắn gọn
    }

}
