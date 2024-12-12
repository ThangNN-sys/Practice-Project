package com.vti.controller;

import com.vti.entity.Exam;
import com.vti.entity.ExamQuestion;
import com.vti.entity.Question;
import com.vti.entity.primarykey.ExamQuestionKey;
import com.vti.service.IExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/exam-questions")
public class ExamQuestionController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: Exam
     */

    @Autowired
    private IExamQuestionService service;

    // get all list
//    @GetMapping()
//    public List<ExamQuestion> getListExamQuestions() {
//        return service.getListExamQuestions();
//    }

    // get all paging
    @GetMapping()
    public Page<ExamQuestion> getAllExamQuestions(Pageable pageable) {
        return service.getAllExamQuestionsPaging(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public ExamQuestion getExamQuestionById(@PathVariable(name = "id") ExamQuestionKey id) {
        return service.getExamQuestionById(id);
    }

    // get by exam
    @GetMapping(value = "/exam/{exam}")
    public ExamQuestion getExamQuestionByExam(@PathVariable(name = "exam") Exam exam) {
        return service.getExamQuestionByExam(exam);
    }

    // get by question
    @GetMapping(value = "/question/{question}")
    public ExamQuestion getExamQuestionByQuestion(@PathVariable(name = "question") Question question) {
        return service.getExamQuestionByQuestion(question);
    }

    // create new
    @PostMapping()
    public void createExamQuestion(@RequestBody ExamQuestion create) {
        service.createExamQuestion(create);
    }

    // update find by id
    @PutMapping(value = "/u1/{id}")
    public void updateExamQuestion1(@PathVariable(name = "id") ExamQuestionKey id, @RequestBody ExamQuestion update1) {
        update1.setId(id);
        service.updateExamQuestion1(id, update1.getExam(),
                update1.getQuestion());
    }

    // update by object
    @PutMapping(value = "/u2")
    public void updateExamQuestion2(@RequestBody ExamQuestion update2) {
        service.updateExamQuestion2(update2);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteExamQuestion(@PathVariable(name = "id") ExamQuestionKey id) {
        service.deleteExamQuestion(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isExamQuestionExistId(@PathVariable(name = "id") ExamQuestionKey id) {
        return service.isExamQuestionExistId(id);
    }

    // exists by exam
    @GetMapping(value = "/exists-exam/{exam}")
    public boolean isExamQuestionExistExam(@PathVariable(name = "exam") Exam exam) {
        return service.isExamQuestionExistsExam(exam);
    }

    // exists by question
    @GetMapping(value = "/exists-question/{question}")
    public boolean isExamQuestionExistQuestion(@PathVariable(name = "question") Question question) {
        return service.isExamQuestionExistsQuestion(question);
    }

}
