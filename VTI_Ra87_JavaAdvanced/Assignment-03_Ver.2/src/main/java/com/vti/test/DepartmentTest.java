package com.vti.test;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

/**
 * Class quản lý các chức năng CRUD
 * Dùng để test các chức năng quản lý thông tin đối với bảng Department
 */

public class DepartmentTest {
	public static void main(String[] args) {
		DepartmentRepository repository = new DepartmentRepository();
		int choice;
		do {
			// %: Bắt đầu một định dạng, -: Căn trái (left-aligned), 48: Độ rộng tối thiểu là 48 ký tự,
			// s: Định dạng chuỗi (string), |: Ký tự này sẽ được thêm vào trước và sau chuỗi in ra, chiếm một ô trong bảng
			// %n: Thay thế cho ký tự xuống dòng (newline) phù hợp với hệ điều hành đang chạy (Windows, Linux, v.v.)
			String leftAlignFormat = "|%-48s|%n";
			System.out.format("+------------------------------------------------+%n");
			System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
			System.out.format("+------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. CREATE NEW DEPARTMENT");
			System.out.format(leftAlignFormat, "2. GET ALL DEPARTMENTS");
			System.out.format(leftAlignFormat, "3. GET DEPARTMENT BY ID");
			System.out.format(leftAlignFormat, "4. UPDATE DEPARTMENT");
			System.out.format(leftAlignFormat, "5. DELETE DEPARTMENT - Closed");
			System.out.format(leftAlignFormat, "6. EXIT");
			System.out.format("+------------------------------------------------+%n");

			choice = ScannerUtils.getPositiveIntInput();

			switch (choice) {
				case 1: // WORK
					System.out.println("***********CREATE NEW DEPARTMENT***********");
					Department depCreate = new Department();
					System.out.println("\nPLEASE ENTER DEPARTMENT NAME:");
					String departmentName = ScannerUtils.getStringInput();
					depCreate.setDepName(departmentName);
					repository.createDepartment(depCreate);
					break;

				case 2: // WORK
					System.out.println("***********GET ALL DEPARTMENT***********");
					List<Department> departments = repository.getAllDepartments();
					for (Department department : departments) {
                        System.out.println("Department: " + department.getDepName());
						System.out.println("----------------------------------");
					}
					break;

				case 3: // WORK
					System.out.println("\n***********GET DEPARTMENT BY ID***********");
					System.out.println("\nPLEASE ENTER ID:");
					short id3 = (short) ScannerUtils.getPositiveIntInput();
					Department depById = repository.getDepartmentByID(id3);
					System.out.println(depById);
					break;

				case 4: // WORK
					System.out.println("\n***********UPDATE DEPARTMENT BY ID***********");
					System.out.println("\nPLEASE ENTER ID:");
					short id4 = (short) ScannerUtils.getPositiveIntInput();
					System.out.println("\nPLEASE ENTER DEPARTMENT NAME:");
					String depName4 = ScannerUtils.getStringInput();
					repository.updateDepartment(id4, depName4);
					break;

				case 5: // Todo: viết lại code
					System.out.println("\n***********DELETE DEPARTMENT BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id5 = (short) ScannerUtils.getPositiveIntInput();
//					repository.deleteDepartment(id5);
//					break;

				case 6: // WORK
					System.out.println("QUIT PROGRAM SUCCESSFULLY");
					break;

				default: // WORK
					System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
			}
		} while (choice != 6);
	}
}



