package com.vti.controller;

import com.vti.entity.CategoryQuestion;
import com.vti.entity.Question;
import com.vti.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/questions")
public class QuestionController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: Question
     */

    @Autowired
    private IQuestionService service;

    // get all list
//    @GetMapping()
//    public List<Question> getListQuestions() {
//        return service.getListQuestions();
//    }

    // get all paging
    @GetMapping()
    public Page<Question> getAllQuestions(Pageable pageable) {
        return service.getAllQuestionsPaging(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public Question getQuestionById(@PathVariable(name = "id") short id) {
        return service.getQuestionById(id);
    }

    // get by category
    @GetMapping(value = "/category/{category}")
    public Question getQuestionByCategory(@PathVariable(name = "category") CategoryQuestion category) {
        return service.getQuestionByCategory(category);
    }

    // create new
    @PostMapping()
    public void createQuestion(@RequestBody Question create) {
        service.createQuestion(create);
    }

    // update name find by id
    @PutMapping(value = "/u1/{id}")
    public void updateQuestion1(@PathVariable(name = "id") short id, @RequestBody Question update1) {
        update1.setId(id);
        service.updateQuestion1(id, update1.getContent());
    }

    // update by object
    @PutMapping(value = "/u2")
    public void updateQuestion2(@RequestBody Question update2) {
        service.updateQuestion2(update2);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteQuestion(@PathVariable(name = "id") short id) {
        service.deleteQuestion(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isQuestionExistId(@PathVariable(name = "id") short id) {
        return service.isQuestionExistsId(id);
    }

    // exists by category
    @GetMapping(value = "/exists-category/{category}")
    public boolean isQuestionExistCategory(@PathVariable(name = "category") CategoryQuestion category) {
        return service.isQuestionExistsCategory(category);
    }

}
