package com.vti.test;

import com.vti.entity.Question;
import com.vti.repository.QuestionRep;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class QuestionProgram {
    public static void main(String[] args) {
        QuestionRep repository = new QuestionRep();
        String leftAlignFormat = "|%-48s|%n";
        System.out.format("+------------------------------------------------+%n");
        System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
        System.out.format("+------------------------------------------------+%n");
        System.out.format(leftAlignFormat, "1. CREATE NEW QUESTION");
        System.out.format(leftAlignFormat, "2. GET ALL QUESTIONS");
        System.out.format(leftAlignFormat, "3. GET QUESTION BY ID");
        System.out.format(leftAlignFormat, "4. GET QUESTION BY CONTENT");
        System.out.format(leftAlignFormat, "5. UPDATE QUESTION BY ID");
        System.out.format(leftAlignFormat, "6. DELETE QUESTION BY ID");
        System.out.format(leftAlignFormat, "7. EXIT");
        System.out.format("+------------------------------------------------+%n");

        int choose = ScannerUtils.getPositiveIntInput();

        switch (choose) {
            case 1: // WORK
                System.out.println("\n***********CREATE NEW QUESTION***********");
                Question questionCreate = new Question();
                System.out.println("\nPLEASE ENTER CONTENT:");
                String content = ScannerUtils.getStringInput();
                questionCreate.setContent(content);
                repository.createQuestion(questionCreate);
                break;
            case 2: // WORK
                System.out.println("***********GET ALL QUESTIONS***********");
                List<Question> questions = repository.getAllQuestions();
                for (Question question : questions) {
                    System.out.println(question);
                }
                break;
            case 3: // WORK
                System.out.println("\n***********GET QUESTION BY ID***********");
                System.out.println("\nPLEASE ENTER ID:");
                short id3 = (short) ScannerUtils.getPositiveIntInput();
                Question questionById = repository.getQuestionByID(id3);
                System.out.println(questionById);
                break;
            case 4: // WORK
                System.out.println("\n***********GET QUESTION BY CONTENT***********");
                System.out.println("\nPLEASE ENTER CONTENT:");
                String content4 = ScannerUtils.getStringInput();
                Question questionByContent = repository.getQuestionByContet(content4);
                System.out.println(questionByContent);
                break;
            case 5:
                System.out.println("\n\n***********UPDATE QUESTION BY ID 1***********");
                System.out.println("\nPLEASE ENTER ID:");
                short id5 = (short) ScannerUtils.getPositiveIntInput();
                System.out.println("\nPLEASE ENTER CONTENT:");
                String content5 = ScannerUtils.getStringInput();
                repository.updateQuestion(id5, content5);

                //		System.out.println("\n\n***********UPDATE ACCOUNT 2***********"); chưa hoàn thành
                //		Account updateAccount = new Account();
                //		updateAccount.setFirstName("update");
                //		updateAccount.setLastName("003");
                //		repository.updateAccount(updateAccount);
                break;
            case 6:
                System.out.println("\n\n***********DELETE QUESTION BY ID***********");
                System.out.println("\nPLEASE ENTER ID:");
                short id6 = (short) ScannerUtils.getPositiveIntInput();
                repository.deleteQuestion(id6);
                break;
            case 7: // WORK
                System.out.println("QUIT PROGRAM SUCCESSFULLY");
                break;
            default:
                System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
        }
    }
}
