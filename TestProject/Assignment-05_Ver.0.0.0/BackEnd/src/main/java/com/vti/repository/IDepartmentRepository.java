package com.vti.repository;

import java.util.List;

import com.vti.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

//	public List<Department> getAllDepartments();
//
//	public Department getDepartmentByID(int id);
//
//	public Department getDepartmentByName(String name);
//
//	public void createDepartment(Department department);
//
//	public void updateDepartment(int id, String newName);
//
//	public void updateDepartment(Department department);
//
//	public void deleteDepartment(int id);
//
//	public boolean isDepartmentExistsByID(int id);
//
//	public boolean isDepartmentExistsByName(String name);

	@Query("SELECT d FROM Department d WHERE name LIKE %?1%")
	Department findByName(String name);

	@Query("SELECT d FROM Department d WHERE name LIKE %?1%")
	Page<Department> findByName(String name, Pageable pageable);
}
