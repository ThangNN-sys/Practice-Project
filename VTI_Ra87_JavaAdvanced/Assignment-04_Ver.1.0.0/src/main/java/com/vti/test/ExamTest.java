package com.vti.test;

import com.vti.entity.*;
import com.vti.repository.ExamRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class ExamTest {
	public static void main(String[] args) {
		ExamRepository repository = new ExamRepository();

		int choice;

		do {
			String leftAlignFormat = "|%-48s|%n";
			System.out.format("+------------------------------------------------+%n");
			System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
			System.out.format("+------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. CREATE NEW EXAM");
			System.out.format(leftAlignFormat, "2. GET ALL EXAMS");
			System.out.format(leftAlignFormat, "3. GET EXAM BY ID");
			System.out.format(leftAlignFormat, "4. UPDATE EXAM");
			System.out.format(leftAlignFormat, "5. DELETE EXAM - Closed");
			System.out.format(leftAlignFormat, "6. EXIT");
			System.out.format("+------------------------------------------------+%n");

			choice = ScannerUtils.getPositiveIntInput();

			switch (choice) {
				case 1:
					System.out.println("***********CREATE NEW EXAM***********");
//					Exam examCreate = new Exam();

					break;

				case 2: // WORK
					System.out.println("***********GET ALL EXAMS***********");
					List<Exam> examList = repository.getAllExams();
					for (Exam exam : examList) {
						System.out.println("Exam: " + exam);
						System.out.println("----------------------------------");
					}
					break;

				case 3:
					System.out.println("\n***********GET EXAM BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id3 = (short) ScannerUtils.getPositiveIntInput();
//					Account accById = repository.getAccByID(id3);
//					System.out.println(accById);
					break;

				case 4:
					System.out.println("\n***********UPDATE EXAM BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id7 = (short) ScannerUtils.getPositiveIntInput();
//					System.out.println("\nPLEASE ENTER FIRSTNAME:");
//					String firstName7 = ScannerUtils.getStringInput();
//					System.out.println("\nPLEASE ENTER LASTNAME:");
//					String lastName7 = ScannerUtils.getStringInput();
//					repository.updateAccount(id7, firstName7, lastName7);
					break;

				case 5:
					System.out.println("\n***********DELETE EXAM BY ID***********");
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

	}
}
