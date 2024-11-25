package com.vti.repository;

import com.vti.entity.TypeQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeQuestionRepository extends JpaRepository<TypeQuestion, Short> {

    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: TypeQuestion
     */

    TypeQuestion findById(short id);

    TypeQuestion findByName(String name);

}
