package com.vti;

import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;
import com.vti.utils.ScannerUltis;

public class ProgramAccount {
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

		int choose = ScannerUltis.inputInt();

		switch (choose) {
			case 1: // WORK
				System.out.println("\n***********CREATE NEW ACCOUNT***********");
				Account accountCreate = new Account();
				System.out.println("\nPLEASE ENTER EMAIL ADDRESS:");
				String email = ScannerUltis.inputEmail();
				System.out.println("\nPLEASE ENTER USERNAME:");
				String userName = ScannerUltis.inputString();
				System.out.println("\nPLEASE ENTER FIRSTNAME:");
				String firstName = ScannerUltis.inputString();
				System.out.println("\nPLEASE ENTER LASTNAME:");
				String lastName = ScannerUltis.inputString();
				accountCreate.setEmail(email);
				accountCreate.setUsername(userName);
				accountCreate.setFirstName(firstName);
				accountCreate.setLastName(lastName);
				repository.createAccount(accountCreate);
				break;
			case 2: // WORK
				System.out.println("***********GET ALL ACCOUNTS***********");
				List<Account> accounts = repository.getAllAccounts();
				for (Account account : accounts) {
					System.out.println(account);
				}
				break;
			case 3: // WORK
				System.out.println("\n***********GET ACCOUNT BY ID***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id = (short) ScannerUltis.inputId();
				Account accountById = repository.getAccountByID(id);
				System.out.println(accountById);
				break;
			case 4: // WORK
				System.out.println("\n***********GET ACCOUNT BY USERNAME***********");
				System.out.println("\nPLEASE ENTER USERNAME:");
				String userName1 = ScannerUltis.inputString();
				Account accountByUserName = repository.getAccountByUserName(userName1);
				System.out.println(accountByUserName);
				break;
			case 5: // WORK
				System.out.println("\n\n***********GET ACCOUNT BY FIRSTNAME***********");
				System.out.println("\nPLEASE ENTER FIRSTNAME:");
				String firstName1 = ScannerUltis.inputString();
				Account accountByFirstName = repository.getAccountByFirstName(firstName1);
				System.out.println(accountByFirstName);
				break;
			case 6: // WORK
				System.out.println("\n\n***********GET ACCOUNT BY LASTNAME***********");
				System.out.println("\nPLEASE ENTER LASTNAME:");
				String lastName1 = ScannerUltis.inputString();
				Account accountByLastName = repository.getAccountByLastName(lastName1);
				System.out.println(accountByLastName);
				break;
			case 7: // WORK
				System.out.println("\n\n***********UPDATE ACCOUNT 1***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id2 = (short) ScannerUltis.inputId();
				System.out.println("\nPLEASE ENTER FIRSTNAME:");
				String firstName2 = ScannerUltis.inputString();
				System.out.println("\nPLEASE ENTER LASTNAME:");
				String lastName2 = ScannerUltis.inputString();
				repository.updateAccount(id2, firstName2, lastName2);

		//		System.out.println("\n\n***********UPDATE ACCOUNT 2***********"); chưa hoàn thành
		//		Account updateAccount = new Account();
		//		updateAccount.setFirstName("update");
		//		updateAccount.setLastName("003");
		//		repository.updateAccount(updateAccount);
				break;
			case 8: // WORK
				System.out.println("\n\n***********DELETE ACCOUNT***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id8 = (short) ScannerUltis.inputId();
				repository.deleteAccount(id8);
				break;
			case 9: // WORK
				System.out.println("QUIT PROGRAM SUCCESSFULLY");
				break;
			default:
				System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
		}
//

//
//
//

//

//
//
//

//
//
//

	}
}
