package com.vti.service;

import com.vti.entity.CategoryQuestion;
import com.vti.repository.ICategoryQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryQuestionService implements ICategoryQuestionService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: CategoryQuestion
     */

    @Autowired
    private ICategoryQuestionRepository repository;

    // get all
    @Override
    public List<CategoryQuestion> getListCategoryQuestions() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<CategoryQuestion> getAllCategoryQuestions(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public CategoryQuestion getCategoryQuestionById(short id) {
        return repository.findCategoryQuestionById(id);
    }

    // get by name with @Query
    @Override
    public CategoryQuestion getCategoryQuestionByName(String name) {
        return repository.findCategoryQuestionByName(name);
    }

    // create new
    @Override
    public void createCategoryQuestion(CategoryQuestion categoryQuestion) {
repository.save(categoryQuestion);
    }

    // update name find by id
    @Override
    public void updateCategoryQuestion1(short id, String newName) {
repository.updateCategoryQuestion1(id, newName);
    }

    // update by object
    @Override
    public void updateCategoryQuestion2(CategoryQuestion categoryQuestion) {
repository.save(categoryQuestion);
    }

    // delete by id
    @Override
    public void deleteCategoryQuestion(short id) {
repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isCategoryQuestionExistId(short id) {
        return repository.existsById(id);
    }

    // exists by name
    @Override
    public boolean isCategoryQuestionExistName(String name) {
        CategoryQuestion categoryQuestion = repository.findCategoryQuestionByName(name);
        return categoryQuestion != null;
        // return repository.findCategoryQuestionByName(name) != null; // cách viết ngắn gọn
    }





















}
