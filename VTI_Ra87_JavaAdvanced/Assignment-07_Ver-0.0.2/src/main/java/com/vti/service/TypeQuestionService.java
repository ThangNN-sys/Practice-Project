package com.vti.service;

import com.vti.entity.TypeQuestion;
import com.vti.repository.ITypeQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeQuestionService implements ITypeQuestionService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: TypeQuestion
     */

    @Autowired
    private ITypeQuestionRepository repository;


    @Override
    public List<TypeQuestion> getAllTypes() {
        return List.of();
    }

    @Override
    public Page<TypeQuestion> getAllTypes(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public TypeQuestion getTypeById(short id) {
        return repository.findById(id);
    }

    @Override
    public TypeQuestion getTypeByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void createType(String name) {

    }

    @Override
    public void updateType(String name) {

    }

    @Override
    public void deleteType(String name) {

    }

    @Override
    public boolean isTypeExistId(short id) {
        return false;
    }

    @Override
    public boolean isTypeExistName(String name) {
        return false;
    }
}
