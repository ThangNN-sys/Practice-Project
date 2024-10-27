package com.vti;


import com.vti.entity.Salary;
import com.vti.entity.enumerate.SalaryName;
import com.vti.repository.SalaryRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class SalaryProgram {
	public static void main(String[] args) {
		SalaryRepository repository = new SalaryRepository();
		String leftAlignFormat = "|%-48s|%n";
		System.out.format("+------------------------------------------------+%n");
		System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
		System.out.format("+------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "1. CREATE NEW SALARY");
		System.out.format(leftAlignFormat, "2. GET ALL SALARIES");
		System.out.format(leftAlignFormat, "3. GET SALARY BY ID");
		System.out.format(leftAlignFormat, "4. GET SALARY BY NAME");
		System.out.format(leftAlignFormat, "5. UPDATE SALARY BY ID");
		System.out.format(leftAlignFormat, "6. DELETE SALARY BY ID");
		System.out.format(leftAlignFormat, "7. EXIT");
		System.out.format("+------------------------------------------------+%n");

		int choose = ScannerUtils.getPositiveIntInput();

		switch (choose) {
			case 1:
				System.out.println("\n***********CREATE NEW SALARY***********");
				Salary salaryCreate = new Salary();
				System.out.println("\nPLEASE ENTER SALARY NAME:");
				String name = ScannerUtils.getStringInput();
				salaryCreate.setName(SalaryName.valueOf(name));
				repository.createSalary(salaryCreate);
				break;
			case 2:
				System.out.println("***********GET ALL SALARIES***********");
				List<Salary> salaries = repository.getAllSalaries();
				for (Salary salary : salaries) {
					System.out.println(salary);
				}
				break;
			case 3:
				System.out.println("\n***********GET SALARY BY ID***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id3 = (short) ScannerUtils.getPositiveIntInput();
				Salary salaryById = repository.getSalaryById(id3);
				System.out.println(salaryById);
				break;
			case 4:
				System.out.println("\n***********GET SALARY BY NAME***********");
				System.out.println("\nPLEASE ENTER SALARY NAME:");
				String salaryName4 = ScannerUtils.getStringInput();
				Salary salaryByName = repository.getSalaryByName(salaryName4);
				System.out.println(salaryByName);
				break;
			case 5:
				System.out.println("\n***********UPDATE SALARY BY ID 1***********");
//				System.out.println("\nPLEASE ENTER ID:");
//				short id5 = (short) ScannerUtils.getPositiveIntegerInput();
//				System.out.println("\nPLEASE ENTER SALARY NAME:");
//				String salaryName5 = ScannerUtils.getStringInput();
//				repository.updateSalary(id5, salaryName5);

		//		System.out.println("\n\n***********UPDATE ACCOUNT 2***********"); chưa hoàn thành
		//		Account updateAccount = new Account();
		//		updateAccount.setFirstName("update");
		//		updateAccount.setLastName("003");
		//		repository.updateAccount(updateAccount);
				break;
			case 6:
				System.out.println("\n\n***********DELETE SALARY BY ID***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id6 = (short) ScannerUtils.getPositiveIntInput();
				repository.deleteSalary(id6);
				break;
			case 7: // WORK
				System.out.println("QUIT PROGRAM SUCCESSFULLY");
				break;
			default:
				System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
		}
	}
}
