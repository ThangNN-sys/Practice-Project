package com.vti;


import com.vti.entity.TypeQuestion;
import com.vti.repository.TypeQuestionRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class TypeQuestionProgram {
	public static void main(String[] args) {
		TypeQuestionRepository repository = new TypeQuestionRepository();
		String leftAlignFormat = "|%-48s|%n";
		System.out.format("+------------------------------------------------+%n");
		System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
		System.out.format("+------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "1. CREATE NEW TYPE QUESTION");
		System.out.format(leftAlignFormat, "2. GET ALL TYPE QUESTIONS");
		System.out.format(leftAlignFormat, "3. GET TYPE QUESTION BY ID");
		System.out.format(leftAlignFormat, "4. GET TYPE QUESTION BY NAME");
		System.out.format(leftAlignFormat, "5. UPDATE TYPE QUESTION BY ID");
		System.out.format(leftAlignFormat, "6. DELETE TYPE QUESTION BY ID");
		System.out.format(leftAlignFormat, "7. EXIT");
		System.out.format("+------------------------------------------------+%n");

		int choose = ScannerUtils.getIntegerInput();

		switch (choose) {
			case 1:
				System.out.println("\n***********CREATE NEW TYPE QUESTION***********");
				TypeQuestion typeQuestionCreate = new TypeQuestion();
				System.out.println("\nPLEASE ENTER USERNAME:");
				String userName = ScannerUtils.getStringInput();
				typeQuestionCreate.setTypeName(userName);
				repository.createTypeQuestion(typeQuestionCreate);
				break;
			case 2:
				System.out.println("***********GET ALL TYPE QUESTIONS***********");
				List<TypeQuestion> typeQuestions = repository.getAllTypeQuestion();
				for (TypeQuestion typeQuestion : typeQuestions) {
					System.out.println(typeQuestion);
				}
				break;
			case 3:
				System.out.println("\n***********GET TYPE QUESTION BY ID***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id3 = (short) ScannerUtils.getPositiveIntInput();
				TypeQuestion typeQuestionById = repository.getTypeQuestionById(id3);
				System.out.println(typeQuestionById);
				break;
			case 4:
				System.out.println("\n***********GET TYPE QUESTION BY NAME***********");
				System.out.println("\nPLEASE ENTER TYPE QUESTION NAME:");
				String typeQuestionName4 = ScannerUtils.getStringInput();
				TypeQuestion typeQuestionByName = repository.getTypeQuestionByName(typeQuestionName4);
				System.out.println(typeQuestionByName);
				break;
			case 5:
				System.out.println("\n\n***********UPDATE TYPE QUESTION BY ID 1***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id5 = (short) ScannerUtils.getPositiveIntInput();
				System.out.println("\nPLEASE ENTER TYPE QUESTION NAME:");
				String typeQuestionName5 = ScannerUtils.getStringInput();
				repository.updateTypeQuestion(id5, typeQuestionName5);

		//		System.out.println("\n\n***********UPDATE ACCOUNT 2***********"); chưa hoàn thành
		//		Account updateAccount = new Account();
		//		updateAccount.setFirstName("update");
		//		updateAccount.setLastName("003");
		//		repository.updateAccount(updateAccount);
				break;
			case 6:
				System.out.println("\n\n***********DELETE TYPE QUESTION BY ID***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id6 = (short) ScannerUtils.getPositiveIntInput();
				repository.deleteTypeQuestion(id6);
				break;
			case 7: // WORK
				System.out.println("QUIT PROGRAM SUCCESSFULLY");
				break;
			default:
				System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
		}
	}
}
