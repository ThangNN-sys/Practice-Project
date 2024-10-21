package com.vti;

import com.vti.entity.Answer;
import com.vti.repository.AnswerRepository;

import java.util.List;

public class ProgramAnswer {
	public static void main(String[] args) {
		AnswerRepository repository = new AnswerRepository();

		System.out.println("***********GET ALL ANSWERS***********");

		List<Answer> answers = repository.getAllAnswers();

		for (Answer answer : answers) {
			System.out.println(answer);
		}

//		System.out.println("\n\n***********GET DEPARTMENT BY ID***********");
//
//		Department departmentById = repository.getDepartmentByID((short) 3);
//		System.out.println(departmentById);
//
//		System.out.println("\n\n***********GET DEPARTMENT BY NAME***********");
//
//		Department departmentByName = repository.getDepartmentByName("Sale");
//		System.out.println(departmentByName);
//
//		System.out.println("\n\n***********CREATE DEPARTMENT***********");
//
//		Department departmentCreate = new Department();
//		departmentCreate.setName("Marketing");
//		repository.createDepartment(departmentCreate);
//
//		System.out.println("\n\n***********UPDATE DEPARTMENT 1***********");
//
//		repository.updateDepartment((short) 3, "Security2");
//
//		System.out.println("\n\n***********UPDATE DEPARTMENT 2***********");
//
//		Department departmentUpdate = new Department();
//		departmentUpdate.setId((short) 3);
//		departmentUpdate.setName("Security2");
//		repository.updateDepartment(departmentUpdate);
//
//		System.out.println("\n\n***********DELETE DEPARTMENTS***********");
//		repository.deleteDepartment((short) 2);
//
//		System.out.println("***********CHECK DEPARTMENT EXISTS BY ID***********");
//		System.out.println(repository.isDepartmentExistsByID((short) 1));
//
//		System.out.println("***********CHECK DEPARTMENT EXISTS BY NAME***********");
//		System.out.println(repository.isDepartmentExistsByName("Security"));

	}
}
