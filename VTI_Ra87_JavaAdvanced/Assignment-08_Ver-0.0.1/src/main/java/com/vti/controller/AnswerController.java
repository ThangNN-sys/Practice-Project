package com.vti.controller;

import com.vti.entity.Answer;
import com.vti.entity.Question;
import com.vti.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/answers")
public class AnswerController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: Answer
     */

    @Autowired
    private IAnswerService service;

    // get all list
//    @GetMapping()
//    public List<Address> getListAddress() {
//        return service.getListAddresses();
//    }

    // get all paging
    @GetMapping()
    public Page<Answer> getAllAnswers(Pageable pageable) {
        return service.getAllAnswers(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public Answer getAnswerById(@PathVariable(name = "id") short id) {
        return service.getAnswerById(id);
    }

    // get by question
    @GetMapping(value = "/question/{question}")
    public Answer getAnswerByQuestion(@PathVariable(name = "question") Question question) {
        return service.getAnswerByQuestion(question);
    }

    // create new
    @PostMapping()
    public void createAnswer(@RequestBody Answer create) {
        service.createAnswer(create);
    }

    // update find by id
    @PutMapping(value = "/u1/{id}")
    public void updateAnswer1(@PathVariable(name = "id") short id, @RequestBody Answer answer) {
        answer.setId(id);
        service.updateAnswer1(id, answer.getContent(), answer.getQuestion(), answer.isCorrect());
    }

    // update by object
    @PutMapping(value = "/u2")
    public void updateAnswer2(@RequestBody Answer answer) {
        service.updateAnswer2(answer);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteAnswer(@PathVariable(name = "id") short id) {
        service.deleteAnswer(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isAnswerExistId(@PathVariable(name = "id") short id) {
        return service.isAnswerExistId(id);
    }

    // exists by question
    @GetMapping(value = "/exists-question/{question}")
    public boolean isAnswerExistQuestion(@PathVariable(name = "question") Question question) {
        return service.isAnswerExistQuestion(question);
    }

}
