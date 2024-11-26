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

    // get all
    @Override
    public List<TypeQuestion> getListTypes() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<TypeQuestion> getAllTypes(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public TypeQuestion getTypeById(short id) {
        return repository.findTypeQuestionById(id);
    }

    // get by name with @Query
    @Override
    public TypeQuestion getTypeByName(String name) {
        return repository.findTypeQuestionByName(name);
    }

    // create new
    @Override
    public void createType(TypeQuestion typeQuestion) {
        repository.save(typeQuestion);
    }

    // update name find by id
    @Override
    public void updateType1(short id, String newName) {
        repository.updateTypeQuestion1(id, newName);
    }

    // update by object
    @Override
    public void updateType2(TypeQuestion typeQuestion) {
        repository.save(typeQuestion);
    }

    // delete by id
    @Override
    public void deleteType(short id) {
        repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isTypeExistId(short id) {
        return repository.existsById(id);
    }

    // exists by name
    @Override
    public boolean isTypeExistName(String name) {
        TypeQuestion typeQuestion = repository.findTypeQuestionByName(name);
        return typeQuestion != null;
        // return repository.findTypeQuestionByName(name) != null; // cách viết ngắn gọn
    }
}
