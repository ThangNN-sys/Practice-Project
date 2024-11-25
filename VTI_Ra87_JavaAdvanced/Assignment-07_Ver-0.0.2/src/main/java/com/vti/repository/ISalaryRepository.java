package com.vti.repository;

import com.vti.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalaryRepository extends JpaRepository<Salary, Short> {

    Salary findById(short id);

    Salary findByName(String name);

}
