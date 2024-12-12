package com.vti.service;

import com.vti.entity.CategoryQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryQuestionService {

    List<CategoryQuestion> getAllCategoryQuestions();

    Page<CategoryQuestion> getAllCategoryQuestionsPaging(Pageable pageable);

    CategoryQuestion getCategoryQuestionById(short id);

    CategoryQuestion getCategoryQuestionByName(String name);

    void createCategoryQuestion(CategoryQuestion categoryQuestion);

    void updateCategoryQuestion1(short id, String newName);

    void updateCategoryQuestion2(CategoryQuestion categoryQuestion);

    void deleteCategoryQuestion(short id);

    boolean isCategoryQuestionExistsId(short id);

    boolean isCategoryQuestionExistsName(String name);

}
