package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Short> {
    Department findById(short id);
    Department findByName(String name);
}
