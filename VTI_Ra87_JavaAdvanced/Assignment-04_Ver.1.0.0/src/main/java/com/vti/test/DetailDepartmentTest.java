package com.vti.test;

/**
 * Class quản lý các chức năng CRUD
 * Dùng để test các chức năng quản lý thông tin đối với bảng DetailDepartment
 */

public class DetailDepartmentTest {
	public static void main(String[] args) {
//		DetailDepartmentRepository repository = new DetailDepartmentRepository();
//		AddressRepository addressRepository = new AddressRepository();
//
//		int choice;
//
//		do {
//			String leftAlignFormat = "|%-48s|%n";
//			System.out.format("+------------------------------------------------+%n");
//			System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
//			System.out.format("+------------------------------------------------+%n");
//			System.out.format(leftAlignFormat, "1. CREATE NEW DETAIL DEPARTMENT");
//			System.out.format(leftAlignFormat, "2. GET ALL DETAIL DEPARTMENTS");
//			System.out.format(leftAlignFormat, "3. GET DETAIL DEPARTMENT BY ID");
//			System.out.format(leftAlignFormat, "4. UPDATE DETAIL DEPARTMENT");
//			System.out.format(leftAlignFormat, "5. DELETE DETAIL DEPARTMENT - Closed");
//			System.out.format(leftAlignFormat, "6. EXIT");
//			System.out.format("+------------------------------------------------+%n");
//
//			choice = ScannerUtils.getPositiveIntInput();
//
//			switch (choice) {
//				case 1:
//					System.out.println("***********CREATE NEW DETAIL DEPARTMENT***********");
//					Account accCreate = new Account();
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
//					break;
//
//				case 2: // WORK
//					System.out.println("***********GET ALL DETAIL DEPARTMENTS***********");
//					List<Account> accounts = repository.getAllAccounts();
//					for (Account account : accounts) {
//						Department department = account.getDepartment();
//						System.out.println("Department: " + department.getDepartmentName());
//						System.out.println("Username: " + account.getUsername());
//						System.out.println("Full Name: " + account.getFullName());
//						System.out.println("----------------------------------");
//					}
//					break;
//
//				case 3: // WORK
//					System.out.println("\n***********GET DETAIL DEPARTMENT BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id3 = (short) ScannerUtils.getPositiveIntInput();
//					Account accById = repository.getAccByID(id3);
//					System.out.println(accById);
//					break;
//
//				case 4:
//					System.out.println("\n***********GET DETAIL DEPARTMENT BY USERNAME***********");
////					System.out.println("\nPLEASE ENTER USERNAME:");
////					String userName4 = ScannerUtils.getStringInput();
////					Account accByUserName = repository.getAccByUserName(userName4);
////					System.out.println(accByUserName);
////					break;
//
//				case 5:
//					System.out.println("\n***********GET DETAIL DEPARTMENT BY FIRSTNAME***********");
////					System.out.println("\nPLEASE ENTER FIRSTNAME:");
////					String firstName5 = ScannerUtils.getStringInput();
////					List accByFirstName = repository.getAccByFirstName(firstName5);
////					for (Object account : accByFirstName) {
////						System.out.println(account);
////					}
////					break;
//
//				case 6:
//					System.out.println("\n***********GET DETAIL DEPARTMENT BY LASTNAME***********");
////					System.out.println("\nPLEASE ENTER LASTNAME:");
////					String lastName6 = ScannerUtils.getStringInput();
////					List accByLastName = repository.getAccByLastName(lastName6);
////					for (Object account : accByLastName) {
////						System.out.println(account);
////					}
////					break;
//
//				case 7: // WORK
//					System.out.println("\n***********UPDATE DETAIL DEPARTMENT BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id7 = (short) ScannerUtils.getPositiveIntInput();
//					System.out.println("\nPLEASE ENTER FIRSTNAME:");
//					String firstName7 = ScannerUtils.getStringInput();
//					System.out.println("\nPLEASE ENTER LASTNAME:");
//					String lastName7 = ScannerUtils.getStringInput();
//					repository.updateAccount(id7, firstName7, lastName7);
//					break;
//
//				case 8:
////					System.out.println("\n***********DELETE DETAIL DEPARTMENT BY ID***********");
////					System.out.println("\nPLEASE ENTER ID:");
////					short id8 = (short) ScannerUtils.getPositiveIntInput();
////					repository.deleteAccount(id8);
////					break;
//
//				case 9: // WORK
//					System.out.println("QUIT PROGRAM SUCCESSFULLY");
//					break;
//
//				default: // WORK
//					System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
//			}
//		} while (choice != 9);











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
