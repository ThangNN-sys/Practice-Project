package com.vti.controller;

import com.vti.entity.CategoryQuestion;
import com.vti.service.ICategoryQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/category-questions")
public class CategoryQuestionController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: Address
     */

    @Autowired
    private ICategoryQuestionService service;

    // get all list
//    @GetMapping()
//    public List<CategoryQuestion> getListCategoryQuestion() {
//        return service.getListCategoryQuestions();
//    }

    // get all paging
    @GetMapping()
    public Page<CategoryQuestion> getAllCategoryQuestions(Pageable pageable) {
        return service.getAllCategoryQuestions(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public CategoryQuestion getCategoryQuestionById(@PathVariable(name = "id") short id) {
        return service.getCategoryQuestionById(id);
    }

    // get by name
    @GetMapping(value = "/name/{name}")
    public CategoryQuestion getCategoryQuestionByName(@PathVariable(name = "name") String name) {
        return service.getCategoryQuestionByName(name);
    }

    // create new
    @PostMapping()
    public void createCategoryQuestion(@RequestBody CategoryQuestion create) {
        service.createCategoryQuestion(create);
    }

    // update name find by id
    @PutMapping(value = "/u1/{id}")
    public void updateCategoryQuestion1(@PathVariable(name = "id") short id, @RequestBody CategoryQuestion categoryQuestion) {
        categoryQuestion.setId(id);
        service.updateCategoryQuestion1(id, categoryQuestion.getName());
    }

    // update by object
    @PutMapping(value = "/u2")
    public void updateCategoryQuestion2(@RequestBody CategoryQuestion categoryQuestion) {
        service.updateCategoryQuestion2(categoryQuestion);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteCategoryQuestion(@PathVariable(name = "id") short id) {
        service.deleteCategoryQuestion(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isCategoryQuestionExistId(@PathVariable(name = "id") short id) {
        return service.isCategoryQuestionExistId(id);
    }

    // exists by name
    @GetMapping(value = "/exists-name/{name}")
    public boolean isCategoryQuestionExistName(@PathVariable(name = "name") String name) {
        return service.isCategoryQuestionExistName(name);
    }

}
