package com.vti.test;

import com.vti.entity.Address;
import com.vti.entity.Department;
import com.vti.entity.DetailDepartment;
import com.vti.repository.DetailDepartmentRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

/**
 * Class quản lý các chức năng CRUD
 * Dùng để test các chức năng quản lý thông tin đối với bảng DetailDepartment
 */

public class DetailDepartmentTest {
	public static void main(String[] args) {
		DetailDepartmentRepository repository = new DetailDepartmentRepository();

		int choice;

		do {
			String leftAlignFormat = "|%-48s|%n";
			System.out.format("+------------------------------------------------+%n");
			System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
			System.out.format("+------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. CREATE NEW DETAIL DEPARTMENT");
			System.out.format(leftAlignFormat, "2. GET ALL DETAIL DEPARTMENTS");
			System.out.format(leftAlignFormat, "3. GET DETAIL DEPARTMENT BY ID");
			System.out.format(leftAlignFormat, "4. UPDATE DETAIL DEPARTMENT");
			System.out.format(leftAlignFormat, "5. DELETE DETAIL DEPARTMENT");
			System.out.format(leftAlignFormat, "6. EXIT");
			System.out.format("+------------------------------------------------+%n");

			choice = ScannerUtils.getPositiveIntInput();

			switch (choice) {
				case 1:
					System.out.println("***********CREATE NEW DETAIL DEPARTMENT***********");
//					DetailDepartment accCreate = new DetailDepartment();
//
//					System.out.println("\nPLEASE ENTER EMAIL ADDRESS:");
//					String email = ScannerUtils.getEmailInput();
//					accCreate.setEmail(email);
//
//					System.out.println("\nPLEASE ENTER USERNAME:");
//					String userName = ScannerUtils.getStringInput();
//					accCreate.setUsername(userName);
//
//					System.out.println("\nPLEASE ENTER FIRSTNAME:");
//					String firstName = ScannerUtils.getStringInput();
//					accCreate.setFirstName(firstName);
//
//					System.out.println("\nPLEASE ENTER LASTNAME:");
//					String lastName = ScannerUtils.getStringInput();
//					accCreate.setLastName(lastName);
//
//					System.out.println("\nPLEASE ENTER DEPARTMENT ID:");
//					short departmentId = ScannerUtils.getShortInput();
//					AccountRepository accountRepoDep = new AccountRepository();
//					Department department1 = accountRepoDep.findDepartmentById(departmentId);
//					accCreate.setDepartment(department1);
//
//					System.out.println("\nPLEASE ENTER POSITION ID:");
//					short positionId = ScannerUtils.getShortInput();
//					AccountRepository accountRepoPos = new AccountRepository();
//					Position position1 = accountRepoPos.findPositionById(positionId);
//					accCreate.setPosition(position1);
//
//					System.out.println("\nPLEASE ENTER SALARY ID:");
//					short salaryId = ScannerUtils.getShortInput();
//					AccountRepository accountRepoSal = new AccountRepository();
//					Salary salary1 = accountRepoSal.findSalaryById(salaryId);
//					accCreate.setSalary(salary1);
//
//					repository.createAccount(accCreate);
					break;

				case 2: // WORK
					System.out.println("***********GET ALL DETAIL DEPARTMENTS***********");
					List<DetailDepartment> detailDepartmentList = repository.getAllDetailDepartments();
					for (DetailDepartment detailDepartment : detailDepartmentList) {
						Department department = detailDepartment;
						Address address = detailDepartment.getAddress();
						System.out.println("Department: " + department.getDepartmentName());
						System.out.println("Address: " + address.getAddressName());
						System.out.println("Emulation Point: " + detailDepartment.getEmulationPoint());
						System.out.println("----------------------------------");
					}
					break;

				case 3:
					System.out.println("\n***********GET DETAIL DEPARTMENT BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id3 = (short) ScannerUtils.getPositiveIntInput();
//					Account accById = repository.getAccByID(id3);
//					System.out.println(accById);
					break;

				case 4:
					System.out.println("\n***********UPDATE DETAIL DEPARTMENT BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id7 = (short) ScannerUtils.getPositiveIntInput();
//					System.out.println("\nPLEASE ENTER FIRSTNAME:");
//					String firstName7 = ScannerUtils.getStringInput();
//					System.out.println("\nPLEASE ENTER LASTNAME:");
//					String lastName7 = ScannerUtils.getStringInput();
//					repository.updateAccount(id7, firstName7, lastName7);
					break;

				case 5:
					System.out.println("\n***********DELETE DETAIL DEPARTMENT BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id8 = (short) ScannerUtils.getPositiveIntInput();
//					repository.deleteAccount(id8);
					break;

				case 6: // WORK
					System.out.println("QUIT PROGRAM SUCCESSFULLY");
					break;

				default: // WORK
					System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
			}
		} while (choice != 6);











//		System.out.println("***********GET ALL***********");
//
//		List<DetailDepartment> DetailDepartments = repository.getAllDetailDepartments();
//
//		for (DetailDepartment detailDepartment : DetailDepartments) {
//			System.out.println(detailDepartment);
//		}
//
//		System.out.println("\n\n***********CREATE***********");
//
//		DetailDepartment detailDepartmentCreate = new DetailDepartment();
//
//		// get address by id
//		Address address = addressRepository.getAddressByID((short) 1);
//		// Address address = new Address("P702");
//
//		detailDepartmentCreate.setAddress(address);
//		detailDepartmentCreate.setDepartmentName("Phong Moi Tao");
//		detailDepartmentCreate.setEmulationPoint((short) 7);
//
//		repository.createDepartment(detailDepartmentCreate);

	}
}
