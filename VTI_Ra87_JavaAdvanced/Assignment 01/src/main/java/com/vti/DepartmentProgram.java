package com.vti;

import java.util.List;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;
import com.vti.utils.ScannerUtils;

public class DepartmentProgram {
	public static void main(String[] args) {
		DepartmentRepository repository = new DepartmentRepository();

		String leftAlignFormat = "|%-48s|%n";
		System.out.format("+------------------------------------------------+%n");
		System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
		System.out.format("+------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "1. CREATE NEW DEPARTMENT");
		System.out.format(leftAlignFormat, "2. GET ALL DEPARTMENTS");
		System.out.format(leftAlignFormat, "3. GET DEPARTMENT BY ID");
		System.out.format(leftAlignFormat, "4. GET DEPARTMENT BY NAME");
		System.out.format(leftAlignFormat, "5. UPDATE DEPARTMENT");
		System.out.format(leftAlignFormat, "6. DELETE DEPARTMENT");
		System.out.format(leftAlignFormat, "7. CHECK DEPARTMENT EXISTS BY ID");
		System.out.format(leftAlignFormat, "8. CHECK DEPARTMENT EXISTS BY NAME");
		System.out.format(leftAlignFormat, "9. EXIT");
		System.out.format("+------------------------------------------------+%n");

		int choose = ScannerUtils.getIntegerInput();

		switch (choose) {
			case 1:
				System.out.println("\n***********CREATE NEW DEPARTMENT***********");
				Department departmentCreate = new Department();
				System.out.println("\nPLEASE ENTER DEPARTMENT NAME:");
				String departmentName = ScannerUtils.getStringInput();
				departmentCreate.setName(departmentName);
				repository.createDepartment(departmentCreate);
				break;
			case 2:
				System.out.println("***********GET ALL DEPARTMENTS***********");
				List<Department> departments = repository.getAllDepartments();
				for (Department department : departments) {
					System.out.println(department);
				}
				break;
			case 3:
				System.out.println("\n***********GET DEPARTMENT BY ID***********");
				short id = (short) ScannerUtils.getPositiveIntInput();
				Department departmentById = repository.getDepartmentByID(id);
				System.out.println(departmentById);
				break;
			case 4:
				System.out.println("\n***********GET DEPARTMENT BY NAME***********");
				String departmentName1 = ScannerUtils.getStringInput();
				Department departmentByName = repository.getDepartmentByName(departmentName1);
				System.out.println(departmentByName);
				break;
			case 5:
				System.out.println("\n***********UPDATE DEPARTMENT 1***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id5 = (short) ScannerUtils.getPositiveIntInput();
				System.out.println("\nPLEASE ENTER DEPARTMENT NAME:");
				String departmentName5 = ScannerUtils.getStringInput();
				repository.updateDepartment(id5, departmentName5);
//				System.out.println("\n\n***********UPDATE DEPARTMENT 2***********");
//				Department departmentUpdate = new Department();
//				departmentUpdate.setId((short) 3);
//				departmentUpdate.setName("Security2");
//				repository.updateDepartment(departmentUpdate);
				break;
			case 6:
				System.out.println("\n***********DELETE DEPARTMENT BY ID***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id6 = (short) ScannerUtils.getPositiveIntInput();
				repository.deleteDepartment(id6);
				break;
			case 7:
				System.out.println("\n***********CHECK DEPARTMENT EXISTS BY ID***********");
				short id7 = (short) ScannerUtils.getPositiveIntInput();
				System.out.println(repository.isDepartmentExistsByID(id7));
				break;
			case 8:
				System.out.println("\n***********CHECK DEPARTMENT EXISTS BY NAME***********");
				String departmentName8 = ScannerUtils.getStringInput();
				System.out.println(repository.isDepartmentExistsByName(departmentName8));
				break;
			case 9: // WORK
				System.out.println("QUIT PROGRAM SUCCESSFULLY");
				break;
			default:
				System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
		}
	}
}
