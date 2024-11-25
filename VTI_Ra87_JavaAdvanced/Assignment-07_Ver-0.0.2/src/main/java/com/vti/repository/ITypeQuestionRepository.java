package com.vti.repository;

import com.vti.entity.TypeQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeQuestionRepository extends JpaRepository<TypeQuestion, Short> {

    TypeQuestion findById(short id);

    TypeQuestion findByName(String name);

}
