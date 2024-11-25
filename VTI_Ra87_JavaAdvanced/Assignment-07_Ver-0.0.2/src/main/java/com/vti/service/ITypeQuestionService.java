package com.vti.service;

import com.vti.entity.TypeQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITypeQuestionService {

    List<TypeQuestion> getAllTypes();

    Page<TypeQuestion> getAllTypes(Pageable pageable);

    TypeQuestion getTypeById(short id);

    TypeQuestion getTypeByName(String name);

    void createType(String name);

    void updateType(String name);

    void deleteType(String name);

    boolean isTypeExistId(short id);

    boolean isTypeExistName(String name);

}
