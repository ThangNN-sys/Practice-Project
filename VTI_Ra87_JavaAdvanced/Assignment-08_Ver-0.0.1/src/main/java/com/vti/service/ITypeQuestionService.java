package com.vti.service;

import com.vti.entity.TypeQuestion;
import com.vti.entity.enumerate.TypeQuestionName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITypeQuestionService {

    List<TypeQuestion> getAllTypes();

    Page<TypeQuestion> getAllTypesPaging(Pageable pageable);

    TypeQuestion getTypeById(short id);

    TypeQuestion getTypeByName(TypeQuestionName name);

    void createType(TypeQuestion typeQuestion);

    void updateType1(short id, TypeQuestionName newName);

    void updateType2(TypeQuestion typeQuestion);

    void deleteType(short id);

    boolean isTypeExistsId(short id);

    boolean isTypeExistsName(TypeQuestionName name);

}
