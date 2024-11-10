package com.vti.test;

import com.vti.entity.Salary;
import com.vti.repository.SalaryRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

/**
 * Class quản lý các chức năng CRUD
 * Dùng để test các chức năng quản lý thông tin đối với bảng Salary
 */

public class SalaryTest {
	public static void main(String[] args) {
		SalaryRepository repository = new SalaryRepository();

		int choice;

		do {
			String leftAlignFormat = "|%-48s|%n";
			System.out.format("+------------------------------------------------+%n");
			System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
			System.out.format("+------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. CREATE NEW SALARY - Closed");
			System.out.format(leftAlignFormat, "2. GET ALL SALARIES");
			System.out.format(leftAlignFormat, "3. GET SALARY BY ID");
			System.out.format(leftAlignFormat, "4. UPDATE SALARY - Closed");
			System.out.format(leftAlignFormat, "5. DELETE SALARY - Closed");
			System.out.format(leftAlignFormat, "6. EXIT");
			System.out.format("+------------------------------------------------+%n");

			choice = ScannerUtils.getPositiveIntInput();

			switch (choice) {
				case 1: // TODO: viết lại hàm để create với kiểu dữ liệu ENUM
					System.out.println("***********CREATE NEW SALARY***********");
//					Salary salaryCreate = new Salary();
//					System.out.println("\nPLEASE ENTER SALARY NAME:");
//					String salaryName = ScannerUtils.getStringInput();
//					salaryCreate.setSalaryName(SalaryName.valueOf(salaryName));
//					repository.createSalary(salaryCreate);
					break;

				case 2: // WORK
					System.out.println("***********GET ALL SALARIES***********");
					List<Salary> salaries = repository.getAllSalaries();
					for (Salary salary : salaries) {
						System.out.println("Salary: " + salary.getSalaryName());
						System.out.println("----------------------------------");
					}
					break;

				case 3: // WORK
					System.out.println("\n***********GET SALARY BY ID***********");
					System.out.println("\nPLEASE ENTER ID:");
					short id3 = (short) ScannerUtils.getPositiveIntInput();
					Salary salaryById = repository.getSalaryByID(id3);
					System.out.println(salaryById);
					break;

				case 4: // TODO: viết hàm để update với kiểu dữ liệu ENUM
					// Chỉ cho phép nhập dữ liệu với các kiểu dữ liệu được quy định
					System.out.println("\n***********UPDATE SALARY BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id4 = (short) ScannerUtils.getPositiveIntInput();
//					System.out.println("\nPLEASE ENTER SALARY NAME:");
//					String salaryName4 = ScannerUtils.getStringInput();
//					repository.updateSalary(id4, salaryName4);
					break;

				case 5: // TODO: viết lại hàm để delete với kiểu dữ liệu ENUM
					System.out.println("\n***********DELETE SALARY BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id5 = (short) ScannerUtils.getPositiveIntInput();
//					repository.deleteSalary(id5);
					break;

				case 6: // WORK
					System.out.println("QUIT PROGRAM SUCCESSFULLY");
					break;

				default: // WORK
					System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
			}
		} while (choice != 6);

	}
}
