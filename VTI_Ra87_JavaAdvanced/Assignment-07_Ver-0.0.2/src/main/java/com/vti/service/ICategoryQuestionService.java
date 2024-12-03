package com.vti.service;

import com.vti.entity.CategoryQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryQuestionService {

    List<CategoryQuestion> getListCategoryQuestions();

    Page<CategoryQuestion> getAllCategoryQuestions(Pageable pageable);

    CategoryQuestion getCategoryQuestionById(short id);

    CategoryQuestion getCategoryQuestionByName(String name);

    void createCategoryQuestion(CategoryQuestion categoryQuestion);

    void updateCategoryQuestion1(short id, String newName);

    void updateCategoryQuestion2(CategoryQuestion categoryQuestion);

    void deleteCategoryQuestion(short id);

    boolean isCategoryQuestionExistId(short id);

    boolean isCategoryQuestionExistName(String name);

}
