package com.vti;

import com.vti.entity.Answer;
import com.vti.repository.AnswerRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class AnswerProgram {
	public static void main(String[] args) {
		AnswerRepository repository = new AnswerRepository();
		String leftAlignFormat = "|%-48s|%n";
		System.out.format("+------------------------------------------------+%n");
		System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
		System.out.format("+------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "1. CREATE NEW ANSWER");
		System.out.format(leftAlignFormat, "2. GET ALL ANSWERS");
		System.out.format(leftAlignFormat, "3. GET ANSWER BY ID");
		System.out.format(leftAlignFormat, "4. UPDATE ANSWER");
		System.out.format(leftAlignFormat, "5. DELETE ANSWER");
		System.out.format(leftAlignFormat, "6. EXIT");
		System.out.format("+------------------------------------------------+%n");

		int choose = ScannerUtils.getIntegerInput();

		switch (choose) {
			case 1: // WORK
				System.out.println("\n***********CREATE NEW ANSWER***********");
				Answer answerCreate = new Answer();
				System.out.println("\nPLEASE ENTER CONTENT:");
				String content = ScannerUtils.getStringInput();
				System.out.println("\nPLEASE ENTER IS CORRECT:");
				boolean correct = ScannerUtils.getBooleanInput();
				answerCreate.setContent(content);
				answerCreate.setCorrect(correct);
				repository.createAnswer(answerCreate);
				break;
			case 2: // WORK
				System.out.println("***********GET ALL ANSWERS***********");
				List<Answer> answers = repository.getAllAnswers();
				for (Answer answer : answers) {
					System.out.println(answer);
				}
				break;
			case 3: // WORK
				System.out.println("\n***********GET ANSWER BY ID***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id = ScannerUtils.getPositiveShortInput();
				Answer answerById = repository.getAnswerByID(id);
				System.out.println(answerById);
				break;
			case 4: // WORK
				System.out.println("\n***********UPDATE ANSWER BY ID 1***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id4 = (short) ScannerUtils.getPositiveIntInput();
				System.out.println("\nPLEASE ENTER CONTENT:");
				String content4 = ScannerUtils.getStringInput();
				System.out.println("\nPLEASE ENTER IS CORRECT:");
				boolean correct4 = ScannerUtils.getBooleanInput();
				repository.updateAnswer(id4, content4, correct4);
				break;
			case 5: // WORK
				System.out.println("\n***********DELETE ANSWER BY ID***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id5 = (short) ScannerUtils.getPositiveIntInput();
				repository.deleteAnswer(id5);
				break;
			case 6: // WORK
				System.out.println("QUIT PROGRAM SUCCESSFULLY");
				break;
			default:
				System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
		}
	}
}