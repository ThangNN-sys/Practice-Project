package com.vti.test;


import com.vti.entity.CategoryQuestion;
import com.vti.repository.CategoryQuestionRep;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class CategoryQuestionProgram {
    public static void main(String[] args) {
        CategoryQuestionRep repository = new CategoryQuestionRep();
        int choice;
        do {
            String leftAlignFormat = "|%-48s|%n";
            System.out.format("+------------------------------------------------+%n");
            System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
            System.out.format("+------------------------------------------------+%n");
            System.out.format(leftAlignFormat, "1. CREATE NEW CATEGORY QUESTION");
            System.out.format(leftAlignFormat, "2. GET ALL CATEGORY QUESTIONS");
            System.out.format(leftAlignFormat, "3. GET CATEGORY QUESTION BY ID");
            System.out.format(leftAlignFormat, "4. GET CATEGORY QUESTION BY NAME");
            System.out.format(leftAlignFormat, "5. DELETE CATEGORY QUESTION BY ID");
            System.out.format(leftAlignFormat, "6. CHECK CATEGORY QUESTION EXISTS BY ID");
            System.out.format(leftAlignFormat, "7. CHECK CATEGORY QUESTION EXISTS BY NAME");
            System.out.format(leftAlignFormat, "8. EXIT");
            System.out.format("+------------------------------------------------+%n");

            choice = ScannerUtils.getPositiveIntInput();

            switch (choice) {
                case 1: // WORK
                    System.out.println("\n***********CREATE NEW CATEGORY QUESTION***********");
                    CategoryQuestion categoryQuestionCreate = new CategoryQuestion();
                    System.out.println("\nPLEASE ENTER CATEGORY QUESTION NAME:");
                    String categoryQuestionName = ScannerUtils.getStringInput();
                    categoryQuestionCreate.setName(categoryQuestionName);
                    repository.createCategoryQuestion(categoryQuestionCreate);
                    break;
                case 2: // WORK
                    System.out.println("\n***********GET ALL CATEGORY QUESTIONS***********");
                    List<CategoryQuestion> categoryQuestions = repository.getAllCategoryQuestions();
                    for (CategoryQuestion categoryQuestion : categoryQuestions) {
                        System.out.println(categoryQuestion);
                    }
                    break;
                case 3: // WORK
                    System.out.println("\n***********GET CATEGORY QUESTION BY ID***********");
                    short id = (short) ScannerUtils.getPositiveIntInput();
                    CategoryQuestion categoryQuestionByID = repository.getCategoryQuestionByID(id);
                    System.out.println(categoryQuestionByID);
                    break;
                case 4: // WORK
                    System.out.println("\n***********GET CATEGORY QUESTION BY NAME***********");
                    String categoryQuestionName4 = ScannerUtils.getStringInput();
                    CategoryQuestion categoryQuestionByName = repository.getCategoryQuestionByName(categoryQuestionName4);
                    System.out.println(categoryQuestionByName);
                    break;
//                case 5: Không sử dụng do trường CategoryName có thuộc tính updateable = false
//                    System.out.println("\n***********UPDATE CATEGORY QUESTION BY ID 1***********");
//                    System.out.println("\nPLEASE ENTER ID:");
//                    short id5 = (short) ScannerUtils.getPositiveIntInput();
//                    System.out.println("\nPLEASE ENTER CATEGORY QUESTION NAME:");
//                    String categoryQuestionName5 = ScannerUtils.getStringInput();
//                    repository.updateCategoryQuestion(id5, categoryQuestionName5);
//    				System.out.println("\n\n***********UPDATE CATEGORY QUESTION 2***********");
//    				Department departmentUpdate = new Department();
//    				departmentUpdate.setId((short) 3);
//    				departmentUpdate.setName("Security2");
//    				repository.updateDepartment(departmentUpdate);
//                    break;
                case 5: // WORK
                    System.out.println("\n***********DELETE CATEGORY QUESTION BY ID***********");
                    System.out.println("\nPLEASE ENTER ID:");
                    short id6 = (short) ScannerUtils.getPositiveIntInput();
                    repository.deleteCategoryQuestion(id6);
                    break;
                case 6: // WORK
                    System.out.println("\n***********CHECK CATEGORY QUESTION EXISTS BY ID***********");
                    short id7 = (short) ScannerUtils.getPositiveIntInput();
                    System.out.println(repository.isCategoryQuestionExistsByID(id7));
                    CategoryQuestion categoryQuestionById7 = repository.getCategoryQuestionByID(id7);
                    System.out.println(categoryQuestionById7);
                    break;
                case 7: // WORK
                    System.out.println("\n***********CHECK CATEGORY QUESTION EXISTS BY NAME***********");
                    String categoryQuestionName8 = ScannerUtils.getStringInput();
                    System.out.println(repository.isCategoryQuestionExistsByName(categoryQuestionName8));
                    CategoryQuestion categoryQuestionByName8 = repository.getCategoryQuestionByName(categoryQuestionName8);
                    System.out.println(categoryQuestionByName8);
                    break;
                case 8: // WORK
                    System.out.println("QUIT PROGRAM SUCCESSFULLY");
                    break;
                default: // WORK
                    System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
            }
        } while (choice != 8);
    }
}
