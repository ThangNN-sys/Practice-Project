package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

    @Qualifier("IDepartmentRepository")
    @Autowired
	private IDepartmentRepository repository;

	public void getAllDepartment(String name) {
		repository.findByName(name);
	}

	public Page<Department> getAllDepartments(Pageable pageable) {
		return repository.findAll(pageable);
	}
	public Page<Department> getDepartmentByName(Pageable pageable, String name) {
		return repository.findByName(name, pageable);
	}

	@Override
	public List<Department> getAllDepartments() {
		return List.of();
	}

	@Override
	public Department getDepartmentByID(int id) {
		return null;
	}

	@Override
	public Department getDepartmentByName(String name) {
		return null;
	}

	@Override
	public void createDepartment(Department department) {

	}

	@Override
	public void updateDepartment(int id, String newName) {

	}

	@Override
	public void updateDepartment(Department department) {

	}

	@Override
	public void deleteDepartment(int id) {

	}

	@Override
	public boolean isDepartmentExistsByID(int id) {
		return false;
	}

	@Override
	public boolean isDepartmentExistsByName(String name) {
		return false;
	}

//	public List<Department> getAllDepartments() {
//		return repository.getAllDepartments();
//	}
//
//	public Department getDepartmentByID(int id) {
//		return repository.getDepartmentByID(id);
//	}
//
//	public Department getDepartmentByName(String name) {
//		return repository.getDepartmentByName(name);
//	}
//
//	public void createDepartment(Department department) {
//		repository.createDepartment(department);
//	}
//
//	public void updateDepartment(int id, String newName) {
//		repository.updateDepartment(id, newName);
//	}
//
//	public void updateDepartment(Department department) {
//		repository.updateDepartment(department);
//	}
//
//	public void deleteDepartment(int id) {
//		repository.deleteDepartment(id);
//	}
//
//	public boolean isDepartmentExistsByID(int id) {
//		return repository.isDepartmentExistsByID(id);
//	}
//
//	public boolean isDepartmentExistsByName(String name) {
//		return repository.isDepartmentExistsByName(name);
//	}
}
