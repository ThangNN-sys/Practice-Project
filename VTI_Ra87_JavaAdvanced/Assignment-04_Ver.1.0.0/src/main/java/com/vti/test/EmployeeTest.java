package com.vti.test;

import com.vti.entity.Employee;
import com.vti.repository.EmployeeRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

/**
 * Class quản lý các chức năng CRUD
 * Dùng để test các chức năng quản lý thông tin đối với bảng Employee
 */

public class EmployeeTest {
	public static void main(String[] args) {
		EmployeeRepository repository = new EmployeeRepository();

		int choice;

		do {
			String leftAlignFormat = "|%-48s|%n";
			System.out.format("+------------------------------------------------+%n");
			System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
			System.out.format("+------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. CREATE NEW EMPLOYEE");
			System.out.format(leftAlignFormat, "2. GET ALL EMPLOYEES");
			System.out.format(leftAlignFormat, "3. GET EMPLOYEE BY ID");
			System.out.format(leftAlignFormat, "4. UPDATE EMPLOYEE");
			System.out.format(leftAlignFormat, "5. DELETE EMPLOYEE - Closed");
			System.out.format(leftAlignFormat, "6. EXIT");
			System.out.format("+------------------------------------------------+%n");

			choice = ScannerUtils.getPositiveIntInput();

			switch (choice) {

				case 1: // TODO: viết lại code để tạo employee mới kèm account trống
					System.out.println("***********CREATE NEW EMPLOYEE***********");
//					Employee employeeCreate = new Employee();
//
//					System.out.println("\nPLEASE ENTER ACCOUNT ID:");
//					short accountId = ScannerUtils.getShortInput();
//					EmployeeRepository employeeRepository = new EmployeeRepository();
//					Account account1 = employeeRepository.findAccountById(accountId);
//					employeeCreate.setAccountId(account1.getAccountId());
//
//					System.out.println("\nPLEASE ENTER WORKING NUMBER OF YEAR:");
//					short workingNumberOfYear = ScannerUtils.getPositiveShortInput();
//					employeeCreate.setWorkingNumberOfYear(workingNumberOfYear);
//
//					repository.createEmployee(employeeCreate);
					break;

				case 2: // WORK
					System.out.println("***********GET ALL EMPLOYEES***********");
					List<Employee> employees = repository.getAllEmployees();
					for (Employee employee : employees) {
						System.out.println(employee);
					}
					break;

				case 3:
					System.out.println("\n***********GET EMPLOYEE BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id3 = (short) ScannerUtils.getPositiveIntInput();
//					Account accById = repository.getAccByID(id3);
//					System.out.println(accById);
					break;

				case 4:
					System.out.println("\n***********UPDATE EMPLOYEE BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id7 = (short) ScannerUtils.getPositiveIntInput();
//					System.out.println("\nPLEASE ENTER FIRSTNAME:");
//					String firstName7 = ScannerUtils.getStringInput();
//					System.out.println("\nPLEASE ENTER LASTNAME:");
//					String lastName7 = ScannerUtils.getStringInput();
//					repository.updateAccount(id7, firstName7, lastName7);
					break;

				case 5:
//					System.out.println("\n***********DELETE EMPLOYEE BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id5 = (short) ScannerUtils.getPositiveIntInput();
//					repository.(id5);
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
