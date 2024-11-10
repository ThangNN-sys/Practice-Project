package com.vti.test;

import com.vti.entity.CategoryQuestion;
import com.vti.repository.CategoryQuestionRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

/**
 * Class quản lý các chức năng CRUD
 * Dùng để test các chức năng quản lý thông tin đối với bảng CategoryQuestion
 */

public class CategoryQuestionTest {
	public static void main(String[] args) {
		CategoryQuestionRepository repository = new CategoryQuestionRepository();

		int choice;

		do {
			String leftAlignFormat = "|%-48s|%n";
			System.out.format("+------------------------------------------------+%n");
			System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
			System.out.format("+------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. CREATE NEW CATEGORY QUESTION");
			System.out.format(leftAlignFormat, "2. GET ALL CATEGORY QUESTIONS");
			System.out.format(leftAlignFormat, "3. GET CATEGORY QUESTION BY ID");
			System.out.format(leftAlignFormat, "4. UPDATE CATEGORY QUESTION");
			System.out.format(leftAlignFormat, "5. DELETE CATEGORY QUESTION");
			System.out.format(leftAlignFormat, "6. EXIT");
			System.out.format("+------------------------------------------------+%n");

			choice = ScannerUtils.getPositiveIntInput();

			switch (choice) {

				case 1: // WORK
					System.out.println("***********CREATE NEW CATEGORY QUESTION***********");
					CategoryQuestion categoryCreate = new CategoryQuestion();
					System.out.println("\nPLEASE ENTER CATEGORY QUESTION NAME:");
					String categoryName = ScannerUtils.getStringInput();
					categoryCreate.setCategoryName(categoryName);
					repository.createCategoryQuestion(categoryCreate);
					break;

				case 2: // WORK
					System.out.println("***********GET ALL SALARIES***********");
					List<CategoryQuestion> categoryQuestions = repository.getAllCategoryQuestions();
					for (CategoryQuestion categoryQuestion : categoryQuestions) {
						System.out.println("Category Question: " + categoryQuestion.getCategoryName());
						System.out.println("----------------------------------");
					}
					break;

				case 3: // WORK
					System.out.println("\n***********GET CATEGORY QUESTION BY ID***********");
					System.out.println("\nPLEASE ENTER ID:");
					short id3 = (short) ScannerUtils.getPositiveIntInput();
					CategoryQuestion categoryById = repository.getCategoryQuestionByID(id3);
					System.out.println(categoryById);
					break;

				case 4: // WORK
					System.out.println("\n***********UPDATE CATEGORY QUESTION BY ID***********");
					System.out.println("\nPLEASE ENTER ID:");
					short id4 = (short) ScannerUtils.getPositiveIntInput();
					System.out.println("\nPLEASE ENTER CATEGORY QUESTION NAME:");
					String categoryName4 = ScannerUtils.getStringInput();
					repository.updateCategoryQuestion(id4, categoryName4);
					break;

				case 5: // WORK
					System.out.println("\n***********DELETE CATEGORY QUESTION BY ID***********");
					System.out.println("\nPLEASE ENTER ID:");
					short id5 = (short) ScannerUtils.getPositiveIntInput();
					repository.deleteCategoryQuestion(id5);
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
