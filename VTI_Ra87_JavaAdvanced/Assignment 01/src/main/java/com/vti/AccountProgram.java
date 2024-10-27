package com.vti;

import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;
import com.vti.utils.ScannerUtils;

public class AccountProgram {
	public static void main(String[] args) {
		AccountRepository repository = new AccountRepository();
		String leftAlignFormat = "|%-48s|%n";
		System.out.format("+------------------------------------------------+%n");
		System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
		System.out.format("+------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "1. CREATE NEW ACCOUNT");
		System.out.format(leftAlignFormat, "2. GET ALL ACCOUNTS");
		System.out.format(leftAlignFormat, "3. GET ACCOUNT BY ID");
		System.out.format(leftAlignFormat, "4. GET ACCOUNT BY USERNAME");
		System.out.format(leftAlignFormat, "5. GET ACCOUNT BY FIRSTNAME");
		System.out.format(leftAlignFormat, "6. GET ACCOUNT BY LASTNAME");
		System.out.format(leftAlignFormat, "7. UPDATE ACCOUNT");
		System.out.format(leftAlignFormat, "8. DELETE ACCOUNT");
		System.out.format(leftAlignFormat, "9. EXIT");
		System.out.format("+------------------------------------------------+%n");

		int choose = ScannerUtils.getIntegerInput();

		switch (choose) {
			case 1: // WORK
				System.out.println("\n***********CREATE NEW ACCOUNT***********");
				Account accountCreate = new Account();
				System.out.println("\nPLEASE ENTER EMAIL ADDRESS:");
				String email = ScannerUtils.getEmailInput();
				System.out.println("\nPLEASE ENTER USERNAME:");
				String userName = ScannerUtils.getStringInput();
				System.out.println("\nPLEASE ENTER FIRSTNAME:");
				String firstName = ScannerUtils.getStringInput();
				System.out.println("\nPLEASE ENTER LASTNAME:");
				String lastName = ScannerUtils.getStringInput();
				accountCreate.setEmail(email);
				accountCreate.setUsername(userName);
				accountCreate.setFirstName(firstName);
				accountCreate.setLastName(lastName);
				repository.createAccount(accountCreate);
				break;
			case 2: // WORK
				System.out.println("\n***********GET ALL ACCOUNTS***********");
				List<Account> accounts = repository.getAllAccounts();
				for (Account account : accounts) {
					System.out.println(account);
				}
				break;
			case 3: // WORK
				System.out.println("\n***********GET ACCOUNT BY ID***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id = (short) ScannerUtils.getPositiveIntInput();
				Account accountById = repository.getAccountByID(id);
				System.out.println(accountById);
				break;
			case 4: // WORK
				System.out.println("\n***********GET ACCOUNT BY USERNAME***********");
				System.out.println("\nPLEASE ENTER USERNAME:");
				String userName1 = ScannerUtils.getStringInput();
				Account accountByUserName = repository.getAccountByUserName(userName1);
				System.out.println(accountByUserName);
				break;
			case 5: // Lỗi khi nhiều account trùng First name
				System.out.println("\n***********GET ACCOUNT BY FIRSTNAME***********");
				System.out.println("\nPLEASE ENTER FIRSTNAME:");
				String firstName1 = ScannerUtils.getStringInput();
				Account accountByFirstName = repository.getAccountByFirstName(firstName1);
				System.out.println(accountByFirstName);
				break;
			case 6: // Lỗi khi nhiều account trùng Last name
				System.out.println("\n***********GET ACCOUNT BY LASTNAME***********");
				System.out.println("\nPLEASE ENTER LASTNAME:");
				String lastName1 = ScannerUtils.getStringInput();
				Account accountByLastName = repository.getAccountByLastName(lastName1);
				System.out.println(accountByLastName);
				break;
			case 7: // WORK
				System.out.println("\n***********UPDATE ACCOUNT 1***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id2 = (short) ScannerUtils.getPositiveIntInput();
				System.out.println("\nPLEASE ENTER FIRSTNAME:");
				String firstName2 = ScannerUtils.getStringInput();
				System.out.println("\nPLEASE ENTER LASTNAME:");
				String lastName2 = ScannerUtils.getStringInput();
				repository.updateAccount(id2, firstName2, lastName2);

		//		System.out.println("\n\n***********UPDATE ACCOUNT 2***********"); chưa hoàn thành
		//		Account updateAccount = new Account();
		//		updateAccount.setFirstName("update");
		//		updateAccount.setLastName("003");
		//		repository.updateAccount(updateAccount);
				break;
			case 8: // WORK
				System.out.println("\n***********DELETE ACCOUNT***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id8 = (short) ScannerUtils.getPositiveIntInput();
				repository.deleteAccount(id8);
				break;
			case 9: // WORK
				System.out.println("QUIT PROGRAM SUCCESSFULLY");
				break;
			default:
				System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
		}
	}
}
